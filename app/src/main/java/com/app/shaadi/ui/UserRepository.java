package com.app.shaadi.ui;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.app.shaadi.common.AppExecutors;
import com.app.shaadi.common.NetworkHelper;
import com.app.shaadi.db.AppDatabase;
import com.app.shaadi.model.Result;
import com.app.shaadi.model.User;
import com.app.shaadi.network.interfaces.ApiInterface;
import com.app.shaadi.network.livedata.ApiResponse;
import com.app.shaadi.network.livedata.NetworkBoundResource;
import com.app.shaadi.network.livedata.Resource;
import java.util.List;

public class UserRepository {
    private static String TAG = "UserRepository";

    private AppExecutors appExecutors;
    private ApiInterface mApiInterface;
    private AppDatabase appDatabase;
    private Application application;

    public UserRepository(Application application,ApiInterface apiInterface, AppDatabase appDatabase, AppExecutors appExecutors) {
        this.application=application;
        this.mApiInterface = apiInterface;
        this.appDatabase = appDatabase;
        this.appExecutors = appExecutors;
    }

    public LiveData<Resource<List<Result>>> getResults() {
        return new NetworkBoundResource<List<Result>, User>(appExecutors) {
            @Override
            protected void saveCallResult(final User user) {
                if (user.getResults()!= null && !user.getResults().isEmpty())
                        appDatabase.beginTransaction();
                        try {
                            appDatabase.userDao().deleteAllUsers();
                            appDatabase.userDao().insertAll(user.getResults());
                            appDatabase.setTransactionSuccessful();
                        } finally {
                            appDatabase.endTransaction();
                        }
            }

            @Override
            protected boolean shouldFetch(@Nullable final List<Result> results) {
                boolean isInternetAvailable=NetworkHelper.isConnectedOrConnecting(application);
                if(isInternetAvailable){
                    return true;
                }else{
                    return results == null || results.isEmpty();
                }
            }

            @NonNull
            @Override
            protected LiveData<List<Result>> loadFromDb() {
                return appDatabase.userDao().results();
            }

            @Override
            @NonNull
            protected LiveData<ApiResponse<User>> createCall() {

                return mApiInterface.users();
            }
        }.asLiveData();
    }

    public void updateReject(int id, int value) {
        appExecutors.diskIO().execute(() -> {
            appDatabase.beginTransaction();
            try {
                long updated = appDatabase.userDao().updateReject(id,value);
                Log.d(TAG, "update Status Value:" + updated);
                appDatabase.setTransactionSuccessful();
            } finally {
                appDatabase.endTransaction();
            }
        });
    }
}

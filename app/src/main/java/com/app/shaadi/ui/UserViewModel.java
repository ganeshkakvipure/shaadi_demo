package com.app.shaadi.ui;

import android.app.Application;
import android.util.Log;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.app.shaadi.R;
import com.app.shaadi.common.AppExecutors;
import com.app.shaadi.db.AppDatabase;
import com.app.shaadi.model.Result;
import com.app.shaadi.network.interfaces.ApiInterface;
import com.app.shaadi.network.livedata.Resource;
import com.app.shaadi.network.livedata.ServiceGeneratorLiveData;
import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private static final String TAG = "UserViewModel";
    private AppDatabase appDatabase;
    private AppExecutors appExecutors;
    private ApiInterface mApiInterface;
    private UserRepository mUserRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        mApiInterface = ServiceGeneratorLiveData.createService(ApiInterface.class);
        this.appExecutors = new AppExecutors();
        this.appDatabase = AppDatabase.getDatabase(getApplication());
        this.mUserRepository = new UserRepository(getApplication(),mApiInterface, appDatabase, appExecutors);

    }

    public LiveData<Resource<List<Result>>> getUsers() {
        return mUserRepository.getResults();
    }


    public void onAcceptClicked(Result result){
        Log.d(TAG,"accept: "+result);
        mUserRepository.updateReject(result.getUserId(),1);
    }


    public void onRejectClicked(Result result){
        Log.d(TAG,"reject: "+result);
        mUserRepository.updateReject(result.getUserId(),2);
    }
}

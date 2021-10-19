package com.app.shaadi.network.livedata;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.app.shaadi.common.AppExecutors;

public abstract class NetworkOnlyResource<ResultType, RequestType> {


    private static final String TAG="NetworkOnlyResource";
    private final AppExecutors appExecutors;

    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    @MainThread
    public NetworkOnlyResource(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
        result.setValue(Resource.loading(null));
        fetchFromNetwork();

    }

    @MainThread
    private void setResultValue(Resource<ResultType> newValue) {
        if (result.getValue() != newValue) {
            result.setValue(newValue);
        }
    }

    private void fetchFromNetwork() {
        LiveData<ApiResponse<RequestType>> apiResponse = createCall();
        result.addSource(apiResponse, response -> {
            result.removeSource(apiResponse);
            if (response.isSuccessful()) {
                appExecutors.diskIO().execute(() -> {
                    RequestType requestType = processResponse(response);
                    ResultType resultType = processResult(requestType);
                    appExecutors.mainThread().execute(() -> setResultValue(Resource.success(resultType))
                    );
                });
            } else {
                onFetchFailed();
                RequestType requestType = processResponse(response);
                ResultType resultType = processResult(requestType);
                setResultValue(Resource.error(new AppException(response.getError()), resultType));
            }
        });


    }

    protected void onFetchFailed() {
    }

    public LiveData<Resource<ResultType>> asLiveData() {
        return result;
    }

    @WorkerThread
    protected RequestType processResponse(ApiResponse<RequestType> response) {
        return response.body;
    }

    @WorkerThread
    protected abstract ResultType processResult(RequestType requestType);

    @NonNull
    @MainThread
    protected abstract LiveData<ApiResponse<RequestType>> createCall();

}

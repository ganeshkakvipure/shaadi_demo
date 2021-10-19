package com.app.shaadi.network.interfaces;

import androidx.lifecycle.LiveData;
import com.app.shaadi.model.User;
import com.app.shaadi.network.livedata.ApiResponse;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("?results=10")
    LiveData<ApiResponse<User>> users();

}



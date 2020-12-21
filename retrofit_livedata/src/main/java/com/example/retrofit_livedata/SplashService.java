package com.example.retrofit_livedata;

import androidx.lifecycle.LiveData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SplashService {
    @GET("HPImageArchive.aspx?format=js&idx=0&n=1")
    Call<BingImg> getBingImg();

    @GET("HPImageArchive.aspx?format=js&idx=0&n=1")
    LiveData<BingImg> getBingImgLiveData();
}

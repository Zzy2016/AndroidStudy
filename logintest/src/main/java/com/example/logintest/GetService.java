package com.example.logintest;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetService {



    @POST("patient/familyUser/login")
    Call<LoginNativeResult> loginResult(@Body JSONObject jsonObject);

}

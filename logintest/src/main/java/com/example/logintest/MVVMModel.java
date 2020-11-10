package com.example.logintest;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/*

http://gateway.test.huidr.com/
* patient/familyUser/login
* */
public class MVVMModel {
    public void getAccountData(String account, MCallback callback) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            callback.onSuccess("success");
        } else {
            callback.onFailed("error");
        }
    }

    //    vcode passwordMD5 osName version  phone
    public void doLogin(JSONObject map, Callback callback) {

//        通过拦截添加参数
//        "Content-Type: application/json", "Charset: UTF-8", "accept: application/json","Connection: Keep-Alive"
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Charset", "UTF-8")
                        .addHeader("accept", "application/json")
                        .addHeader("Connection", "Keep-Alive")
                        .addHeader("Content-Type", "application/json").build();
                return chain.proceed(request);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.huidr.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        GetService getService = retrofit.create(GetService.class);
        Call<LoginNativeResult> call = getService.loginResult(map);
        call.enqueue(callback);
    }
}

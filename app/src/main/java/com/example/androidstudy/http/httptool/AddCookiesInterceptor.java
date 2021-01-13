package com.example.androidstudy.http.httptool;

import android.graphics.Interpolator;


import com.example.androidstudy.config.Constants;
import com.example.androidstudy.util.NetworkUtils;
import com.orhanobut.hawk.Hawk;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {


        if(!NetworkUtils.isConnected()){
            throw new HttpException("网络连接异常,请检查网络后重试");
        }

        Request.Builder builder=chain.request().newBuilder();
        HashSet<String> preference= Hawk.get(Constants.HawkCode.COOKIE);
        if(preference!=null){
            for(String cookie:preference){
                builder.addHeader("Cookie",cookie);

            }
        }
        return chain.proceed(builder.build());
    }
}

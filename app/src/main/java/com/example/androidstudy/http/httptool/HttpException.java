package com.example.androidstudy.http.httptool;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.example.androidstudy.http.data.HttpBaseResponse;

public class HttpException extends RuntimeException{

    private int code;
    private String message;
    private HttpBaseResponse response;

    public HttpException(String message){
        this.message=message;
    }

    public HttpException(int code,String message){
        this.message=message;
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    @Nullable
    @Override
    public String getMessage() {
        return TextUtils.isEmpty(message)?"":message;
    }
}

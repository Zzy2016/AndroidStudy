package com.example.retrofit_livedata;

public class ApiResponse<T> {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR = 1;

    public int code;
    public String msg;
    public T data;

    public ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ApiResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
}

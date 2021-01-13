package com.example.androidstudy.http.data;

import java.io.Serializable;

/*数据封装类型*/
public class HttpBaseResponse<T> implements Serializable {
    public int errorCode;
    public String errorMsg;
    public T data;
}

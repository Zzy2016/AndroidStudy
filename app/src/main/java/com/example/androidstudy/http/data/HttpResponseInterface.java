package com.example.androidstudy.http.data;

import com.google.gson.Gson;

public interface HttpResponseInterface {
    /*获取处理掉code和msg之后的信息*/
    String getResponseData(Gson gson,String response);
}

package com.example.pagingtest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("users?page=1&pagesize=6&site=stackoverflow")
    Call<ListBean> getList();

}

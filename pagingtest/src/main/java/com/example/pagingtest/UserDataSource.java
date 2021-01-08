package com.example.pagingtest;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataSource extends PageKeyedDataSource<Integer,ListBean.ItemsBean> {

    public static final int FIRST_PAGE=1;
    public static final int PER_PAGE=8;
    public static final String  SITE="stackoverflow";



    //首次加载数据时，调用loadinitial,
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ListBean.ItemsBean> callback) {
        RetrofitClient.getInstance().getApi()
                .getList().enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                if(response.body()!=null){
                    callback.onResult(response.body().getItems(),null,FIRST_PAGE+1);

                    Log.e("jiazai","0");
                }else{
                    Log.e("jiazai","00");
                }
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {
                Log.e("jiazai","1"+t.toString());
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ListBean.ItemsBean> callback) {

    }

    //加载下一页的工作在该方法内进行，
    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ListBean.ItemsBean> callback) {
        RetrofitClient.getInstance().getApi().getList().enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                if(response.body()!=null){
                    Integer nextKey=response.body().isHas_more()? params.key+1:null;
                    callback.onResult(response.body().getItems(),nextKey);
                }
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {

            }
        });
    }
}

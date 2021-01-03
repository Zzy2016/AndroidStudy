package com.example.pagingtest;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class DataSourceFactory extends DataSource.Factory<Integer,ListBean.ItemsBean> {
    private MutableLiveData<UserDataSource>   liveDataSource=new MutableLiveData<>();
    @NonNull
    @Override
    public DataSource<Integer, ListBean.ItemsBean> create() {
        UserDataSource dataSource=new UserDataSource();
        liveDataSource.postValue(dataSource);
        return dataSource;
    }
}

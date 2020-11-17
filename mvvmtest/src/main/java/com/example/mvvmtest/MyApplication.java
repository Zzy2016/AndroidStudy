package com.example.mvvmtest;

import me.goldze.mvvmhabit.base.BaseApplication;

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseApplication.setApplication(this);
    }
}

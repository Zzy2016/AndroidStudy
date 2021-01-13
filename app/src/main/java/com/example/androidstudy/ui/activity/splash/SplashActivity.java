package com.example.androidstudy.ui.activity.splash;

import android.os.Bundle;
import com.example.androidstudy.R;
import com.example.androidstudy.base.BaseActivity;
import com.example.androidstudy.config.App;
import com.example.androidstudy.databinding.ActivitySplashBinding;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> {


    private SplashViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.firstOpen=true;
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
    }


    @Override
    protected boolean isNoActivityBar() {
        return true;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViewModel() {
        viewModel=new SplashViewModel();
    }

    @Override
    protected void bindViewModel() {

    }

    @Override
    protected void init() {

    }
}
package com.example.androidstudy.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.example.androidstudy.config.LoadState;
import com.example.androidstudy.R;
import com.example.androidstudy.databinding.ActivityBaseBinding;
import com.example.androidstudy.databinding.ViewLoadErrorBinding;
import com.example.androidstudy.databinding.ViewLoadingBinding;
import com.example.androidstudy.databinding.ViewNoDataBinding;
import com.example.androidstudy.databinding.ViewNoNetworkBinding;

public abstract class BaseActivity<DB extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity {

    public DB mDataBinding;
    protected VM mViewModel;

    private ActivityBaseBinding mActivityBaseBinding;
    private ViewLoadErrorBinding mViewLoadErrorBinding;
    private ViewLoadingBinding mViewLoadingBinding;
    private ViewNoDataBinding mViewNoDataBinding;
    private ViewNoNetworkBinding mViewNoNetworkBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        handleIntent(getIntent());

        if(isNoActivityBar()){
            setNoActivityBar();
        }

        mActivityBaseBinding=DataBindingUtil.setContentView(this,R.layout.activity_base);
        mDataBinding=DataBindingUtil.inflate(getLayoutInflater(),getLayoutResId(),mActivityBaseBinding.flContentContainer,true);

        initViewModel();
        bindViewModel();


        mDataBinding.setLifecycleOwner(this);


        initLoadState();
        init();


        if(mViewModel!=null){
            getLifecycle().addObserver(mViewModel);
        }

    }

//    状态栏
    private void setNoActivityBar(){
        Window window=getWindow();
        View decorView=window.getDecorView();
        int option=View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
//

    private void initLoadState(){
        if(mViewModel!=null&&isSupportLoad()){
            mViewModel.loadState.observe(this, new Observer<LoadState>() {
                @Override
                public void onChanged(LoadState loadState) {
                    switchLoadView(loadState);
                }
            });
        }
    }

    private void removeLoadView(){
        int childCount=mActivityBaseBinding.flContentContainer.getChildCount();
        if(childCount>1){
            mActivityBaseBinding.flContentContainer.removeViews(1,childCount-1);
        }
    }

    private void switchLoadView(LoadState loadState){
        removeLoadView();
        switch (loadState){
            case LOADING:
                if(mViewLoadingBinding==null){
                    mViewLoadingBinding= DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_loading,
                            mActivityBaseBinding.flContentContainer,false);
                }
                mActivityBaseBinding.flContentContainer.addView(mViewLoadingBinding.getRoot());
                break;
            case NO_NETWORK:
                if(mViewNoNetworkBinding==null){
                 mViewNoNetworkBinding=DataBindingUtil.inflate(getLayoutInflater(),R.layout.view_no_network,
                         mActivityBaseBinding.flContentContainer,false);
                }
                mActivityBaseBinding.flContentContainer.addView(mViewNoNetworkBinding.getRoot());
                break;
            case ERROR:
                if(mViewLoadErrorBinding==null){
                    mViewLoadErrorBinding=DataBindingUtil.inflate(getLayoutInflater(),R.layout.view_load_error,
                            mActivityBaseBinding.flContentContainer,false);
                }
                mActivityBaseBinding.flContentContainer.addView(mViewLoadErrorBinding.getRoot());
                break;
            case NO_DATA:
                if(mViewNoDataBinding==null){
                    mViewNoDataBinding=DataBindingUtil.inflate(getLayoutInflater(),R.layout.view_no_data,
                            mActivityBaseBinding.flContentContainer,false);
                }
                mActivityBaseBinding.flContentContainer.addView(mViewNoDataBinding.getRoot());
                break;
        }
    }

    /*参数容器*/
    protected void handleIntent(Intent intent){

    }

    /*是否沉浸式*/
    protected boolean isNoActivityBar(){
        return false;
    }

    /*是否支持页面加载，默认不支持*/
    protected boolean isSupportLoad(){
        return false;
    }

    /*获取当前页面的布局资源ID*/
    protected abstract int getLayoutResId();

    /*初始化ViewModel*/
    protected abstract void initViewModel();

    /*绑定ViewModel*/
    protected abstract void bindViewModel();

    /*初始化*/
    protected abstract void init();
}

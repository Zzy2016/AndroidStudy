package com.example.androidstudy.base;

import android.content.res.Resources;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.load.model.ModelLoader;
import com.example.androidstudy.App;
import com.example.androidstudy.LoadState;

public class BaseViewModel extends ViewModel implements DefaultLifecycleObserver {

    public Resources resources;
    public MutableLiveData<Object> collect=new MutableLiveData<>();

    public MutableLiveData<LoadState> loadState=new MutableLiveData<>();

    public MutableLiveData<String> errorMsg=new MutableLiveData<>("加载错误");


    public boolean mRefresh;

    public void reloadData{

    }

    public Resources getResources(){
        if(resources==null){
            resources= App.getContext().getResources();
        }
        return resources;
    }

}

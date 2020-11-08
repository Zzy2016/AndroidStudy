package com.example.lifecycletest;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLocationObserver implements LifecycleObserver {
    private static final String TAG="MyLifeCycleObserver";

    public MyLocationObserver() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onActivityResume(){
        Log.e(TAG,"onActivityResume");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onActivityPause(){
        Log.e(TAG,"onActivityPause");
    }
}

package com.example.androidstudy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class App extends Application {
    private static Context context;
    public static boolean firstOpen;

    @Override
    public void onCreate() {
        super.onCreate();
        firstOpen=true;
        context=this;
        initActivityManager();

    }

    public static Context getContext() {
        return context;
    }

//    管理Activity
    private void initActivityManager(){
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }

    private void init(){
    }

//    请求配置
    public static void setHttpConfig(){

    }

//    设置上拉刷新 下拉加载的样式
    static {
//
}
}

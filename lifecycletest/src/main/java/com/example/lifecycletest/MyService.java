package com.example.lifecycletest;

import androidx.lifecycle.LifecycleService;

public class MyService extends LifecycleService {
    public MyService() {
        getLifecycle().addObserver(new MyServiceObserver());
    }
}

package com.example.mvctest.mvvm;

public class NumModel {
    private int num = 0;

    public void add(ModelCallback callback) {
        callback.onSuccess(++num);
    }

    public interface ModelCallback {
        void onSuccess(int num);

        void onFailed(String text);
    }
}

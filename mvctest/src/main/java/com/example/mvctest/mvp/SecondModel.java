package com.example.mvctest.mvp;

import java.util.Calendar;

public class SecondModel {
    private int num = 0;

    public void add(CallBack callBack) {
        callBack.onSuccess(++num);
    }

    public interface CallBack {
        void onSuccess(int num);

        void onFail(String error);
    }
}

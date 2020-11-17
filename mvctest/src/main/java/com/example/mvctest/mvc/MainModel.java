package com.example.mvctest.mvc;

public class MainModel {
    private int num = 0;

    public void add(MainActivity mainActivity) {
        num++;
        mainActivity.updateUI(String.valueOf(num));
    }
}

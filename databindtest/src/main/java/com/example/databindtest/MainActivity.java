package com.example.databindtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.lang.annotation.Target;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    User user;

    private final static String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);




//        Activity binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        User user = new User("小", "ming");
//        binding.setVariable("user", user);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }
}

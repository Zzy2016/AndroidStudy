package com.example.databindtest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.TextView;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Calendar calendar=Calendar.getInstance();

//        time  Wed Nov 04 11:04:25 GMT+08:00 2020

        ((TextView)findViewById(R.id.tv)).setText(calendar.getTime()+"");


    }



    //    锁屏
    public void weakUp(){
        PowerManager powerManager= (PowerManager) getSystemService(POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag")
        PowerManager.WakeLock wakeLock=powerManager.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP|PowerManager.SCREEN_DIM_WAKE_LOCK,"test");
        wakeLock.acquire();
    }

}

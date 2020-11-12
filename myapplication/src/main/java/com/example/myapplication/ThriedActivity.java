package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;

public class ThriedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thried);

        CustomSelectView customSelectView = findViewById(R.id.dateSelectView);
        customSelectView.setCallBack(new CustomSelectView.callBack() {
            @Override
            public void doSelect(String month, String day) {
                Log.e("-----",month+"  "+day);
           }
        });



    }
}
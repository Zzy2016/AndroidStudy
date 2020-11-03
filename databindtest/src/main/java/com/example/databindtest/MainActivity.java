package com.example.databindtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.databindtest.databinding.ActivityMainBindingImpl;

public class MainActivity extends AppCompatActivity {


    User user;

    ActivityMainBindingImpl activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        user = new User("xiaoming", "daming");

        activityMainBinding = ActivityMainBindingImpl.inflate(getLayoutInflater());

    }
}

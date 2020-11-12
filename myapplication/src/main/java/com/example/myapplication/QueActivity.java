package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityQueBinding;

public class QueActivity extends AppCompatActivity {


    ActivityQueBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_que);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_que);

    }
}
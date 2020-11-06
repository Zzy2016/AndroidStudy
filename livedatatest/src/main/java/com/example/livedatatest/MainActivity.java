package com.example.livedatatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


//LiveData 是一种可观察的数据存储器类。与常规的可观察类不同，LiveData 具有生命周期感知能力，
//        意指它遵循其他应用组件（如 Activity、Fragment 或 Service）的生命周期。这种感知能
//        力可确保 LiveData 仅更新处于活跃生命周期状态的应用组件观察者。

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
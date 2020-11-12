package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityLineRecyclerBinding;

import java.util.List;

public class LineRecyclerActivity extends AppCompatActivity {


    ActivityLineRecyclerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_line_recycler);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_line_recycler);

        getSupportActionBar().setTitle("我的测试");
        getActionBar();
        binding.rvList.setAdapter(new LineAdapter());
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
    }
}
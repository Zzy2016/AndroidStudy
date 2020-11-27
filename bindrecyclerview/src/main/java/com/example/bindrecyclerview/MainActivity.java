package com.example.bindrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.bindrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    private ArrayList<String> firstList = new ArrayList<>();
    private ArrayList<String> secondList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//条目模拟数据
        firstList.add("1.单选:你是谁");
        firstList.add("2.单选:你是谁");
        firstList.add("3.单选:你是谁");
        firstList.add("4.单选:你是谁");
        firstList.add("5.单选:你是谁");
        //选项模拟数据
        secondList.add("选项A");
        secondList.add("选项B");
        secondList.add("选项C");
        secondList.add("选项D");
        secondList.add("选项E");
        secondList.add("选项E1");
        secondList.add("选项E2");
        secondList.add("选项E3");
        secondList.add("选项E4");
        secondList.add("选项E5");
        binding.rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));
        FirstAdapter firstAdapter = new FirstAdapter(MainActivity.this,firstList,secondList);
        binding.rv.setAdapter(firstAdapter);
        binding.rv.setItemViewCacheSize(500);
    }
}
package com.example.databindtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import com.example.databindtest.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    TestSelect testSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        binding = DataBindingUtil.setContentView(MainActivity2.this, R.layout.activity_main2);

        Goods goods = new Goods("name", "1", 1f);
        binding.setGoods(goods);
//                new GsmCellLocation();

        testSelect = new TestSelect(true);
        binding.setTest(testSelect);
        binding.setTestHandler(new TestHandler());


//        binding.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//            }
//        });
    }

    public class TestHandler {
        public void doSelect(View view,boolean isChecked) {
            Log.e("-------",isChecked+"");
        }
    }
}
package com.example.databindtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.Converters;

import android.os.Bundle;

import com.example.databindtest.databinding.ActivityThriedBinding;

import java.util.Random;

public class ThriedActivity extends AppCompatActivity {

    ActivityThriedBinding binding;
    Goods goods;

    Test test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thried);

        binding = DataBindingUtil.setContentView(ThriedActivity.this, R.layout.activity_thried);
        binding.setLifecycleOwner(this);

        test = new Test("name");
        goods = new Goods("name", "detail", 1f);
        binding.setGoods(goods);
        binding.setGoodHandler(new GoodsHandler());
//        binding.setTest(test);
    }

    public class GoodsHandler {
        public void changeGoodsName() {
            goods.setName("code" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
            test.name.set(String.valueOf(new Random().nextInt(100)));
        }

        public void changeGoodsDetails() {
            goods.setDetails("hi" + new Random().nextInt(100));
            goods.setPrice(new Random().nextInt(100));
        }


    }
}
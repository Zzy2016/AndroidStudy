package com.example.retrofit_livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitManager.get("https://cn.bing.com/")
                .create(SplashService.class)
                .getBingImgLiveData().observe(this, new Observer<BingImg>() {
            @Override
            public void onChanged(BingImg bingImg) {
                Log.d("-------------", "onChanged: 请求结果："+new Gson().toJson(bingImg));
            }
        });
    }
}

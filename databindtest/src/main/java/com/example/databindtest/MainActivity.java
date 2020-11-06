package com.example.databindtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ViewDataBinding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.databindtest.databinding.ActivityMainBinding;

import java.io.File;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    User user;

    private final static String TAG = "MainActivity";

    ActivityMainBinding binding;

    private List list;


    Map map;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);


        map = new HashMap();
        map.put("key1", "1");
        map.put("key2", "2");



        list = new ArrayList();
        list.add("111");
        list.add("222");
        list.add("333");


        binding.setMap(map);
        binding.setList(list);
//        binding.setUser(new User());
        binding.btn.setText("123");
        binding.setUser(new User("first", "last"));
        binding.setOnClickTest(new SendClass());

    }


    public class SendClass {
        public void sendText() {

            Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_LONG).show();

        }

        public void sendHtml(View view) {
            Uri uri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.drawable.logo);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
            intent.putExtra(Intent.EXTRA_TEXT, "文本");
            startActivity(intent);
        }

        public void sendXml(View view) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("application/xhtml+xml");
            intent.putExtra(Intent.EXTRA_TEXT, "文本");
            startActivity(intent);
        }


    }

}

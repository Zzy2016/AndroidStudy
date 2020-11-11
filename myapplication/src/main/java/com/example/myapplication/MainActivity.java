package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB1"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB2"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB3"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB4"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB5"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB6"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB7"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB8"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB9"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB10"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB11"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB12"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB13"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB14"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB15"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB16"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB17"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB18"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB19"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB20"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB21"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB22"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB23"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB24"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB25"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB26"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB27"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB28"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB29"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("TAB30"));


//        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
//
//
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//
//        WindowMetrics windowMetrics =windowManager.getCurrentWindowMetrics();
//        Log.e("=========", windowMetrics.+ "");
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (!Settings.canDrawOverlays(this)) {
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivityForResult(intent, 1);
//            } else {
//                //TODO do something you need
//                add();
//            }
//        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("Acction-Down",event.getX()+"");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("Acction-Move",event.getX()+"");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("Acction-Down",event.getX()+"");
                break;
        }
        return super.onTouchEvent(event);
    }

    //    public void add() {
//        Button button = new Button(this);
//        button.setText("test");
//        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        params.width = 200;
//        params.height = 200;
//        params.gravity = Gravity.LEFT | Gravity.TOP;
//        params.x = 100;
//        params.y = 200;
////        button.setLayoutParams(params);
//        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
//        windowManager.addView(button, params);
//
//    }


}

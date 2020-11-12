package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Insets;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.tabLayoutMonth.addTab(binding.tabLayoutMonth.newTab().setText("1"));
        binding.tabLayoutMonth.addTab(binding.tabLayoutMonth.newTab().setText("2"));
        binding.tabLayoutMonth.addTab(binding.tabLayoutMonth.newTab().setText("3"));
        binding.tabLayoutMonth.addTab(binding.tabLayoutMonth.newTab().setText("4"));


        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("1"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("2"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("3"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("4"));

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getText().toString()) {
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        binding.rvDate.setAdapter(new DateAdapter(MainActivity.this));
        binding.rvDate.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        binding.rvDate.addOnScrollListener(new RecyclerView.OnScrollListener() {

            //            scrollState = SCROLL_STATE_TOUCH_SCROLL(1)：表示正在滚动。当屏幕滚动且用户使用的触碰或手指还在屏幕上时为1
//            scrollState =SCROLL_STATE_FLING(2) ：表示手指做了抛的动作（手指离开屏幕前，用力滑了一下，屏幕产生惯性滑动）。
//            crollState =SCROLL_STATE_IDLE(0) ：表示屏幕已停止。屏幕停止滚动时为0
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("Recycler", "onScrollStateChanged" + "  " + newState);
            }

//            recyclerView : 当前滚动的view
//            dx : 水平滚动距离
//            dy : 垂直滚动距离
//            dx > 0 时为手指向左滚动,列表滚动显示右面的内容
//            dx < 0 时为手指向右滚动,列表滚动显示左面的内容
//            dy > 0 时为手指向上滚动,列表滚动显示下面的内容
//            dy < 0 时为手指向下滚动,列表滚动显示上面的内容


            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e("Recycler", "onScrolled" + dx + "  " + dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    int first = layoutManager.findFirstVisibleItemPosition();
                    int last = layoutManager.findLastVisibleItemPosition();
                    int count = last - first;
                    if (last == 0) {
                        count = 0;
                    }
                    Log.e("Recycler", "onScrolled  visible" + first + "  " + last);


                }

            }


        });


//        CustomSelectView customSelectView=binding.dateSelectView;
//

        Log.e("--------dateSelectView",(binding.dateSelectView==null)+"");

        if(binding.dateSelectView!=null){
            binding.dateSelectView.setCallBack(new CustomSelectView.callBack() {
                @Override
                public void doSelect(String month, String day) {
                    Log.e("选中日期", month + "  " + day);
                }
            });
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("Acction-Down", event.getX() + "");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("Acction-Move", event.getX() + "");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("Acction-Down", event.getX() + "");
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

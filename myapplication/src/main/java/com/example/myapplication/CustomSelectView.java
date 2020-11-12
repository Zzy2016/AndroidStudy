package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databinding.CustomViewBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;


public class CustomSelectView extends LinearLayout {

    private Context context;
    private CustomViewBinding binding;

    //开始日期，结束日期
    private String dateStart, dateEnd;
    private Calendar calendarStart, calendarEnd;

    //    /选中日期
    private String selectMonth;
    private String SelectDay;


    public CustomSelectView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public CustomSelectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public CustomSelectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    public void initDate() {
        calendarStart = Calendar.getInstance();
        calendarEnd = Calendar.getInstance();
    }


    interface callBack {
        void doSelect(String month, String day);
    }

    callBack callBack;

    public void setCallBack(CustomSelectView.callBack callBack) {
        this.callBack = callBack;
    }

    public void initView() {
        initDate();

        View view = LayoutInflater.from(context).inflate(R.layout.custom_view, this);
        view.setTag("layout/custom_view_0");
        binding = DataBindingUtil.bind(view);

        binding.tabLayout1.addTab(binding.tabLayout1.newTab().setText("1"));
        binding.tabLayout1.addTab(binding.tabLayout1.newTab().setText("2"));
        binding.tabLayout1.addTab(binding.tabLayout1.newTab().setText("3"));
        binding.tabLayout1.addTab(binding.tabLayout1.newTab().setText("4"));


        binding.tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.doSelect("1", "1");
            }
        });
    }


}

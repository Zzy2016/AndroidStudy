package com.example.recyclerviewbindjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.recyclerviewbindjava.databinding.ActivityMainBinding;

/*
* ViewStub  是一个大小为0 ，默认不可见的控件，只有给他设置成了View.Visible或调用了它的inflate()之后才会填充布局资源，也就是说占用资源少。
* //inflate 方法只能被调用一次，因为调用后viewStub对象就被移除了视图树；
                // 所以，如果此时再次点击显示按钮，就会崩溃，错误信息：ViewStub must have a non-null ViewGroup viewParent；
                // 所以使用try catch ,当此处发现exception 的时候，在catch中使用setVisibility()重新显示
android:inflatedId或者调用ViewStub的setInflatedId方法为懒加载视图的跟节点设置ID
* */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int i = 0;

    View viewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (viewStub == null) {
                    try {
                        viewStub = binding.viewStub.inflate();

                    } catch (Exception e) {

                    }
                } else {
                    binding.viewStub.setVisibility(View.VISIBLE);
                }


                i = 1;
            }
        });


        binding.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                binding.viewStub.setVisibility(View.INVISIBLE);
            }
        });

        binding.tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
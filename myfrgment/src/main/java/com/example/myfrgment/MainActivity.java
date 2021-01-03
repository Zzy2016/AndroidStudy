package com.example.myfrgment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.graphics.HardwareRenderer;
import android.os.Bundle;
import android.view.FrameMetrics;
import android.view.View;

import com.example.myfrgment.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    private HomeFragment homeFragment;
    private SetFragment setFragment;
    private CustomAdapter customAdapter;
    private CustomAdapter1 customAdapter1;
    private List<Fragment> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        homeFragment=new HomeFragment();
        setFragment=new SetFragment();
        list=new ArrayList<>();
        list.add(homeFragment);
        list.add(setFragment);
        customAdapter=new CustomAdapter(getSupportFragmentManager(),list);
        customAdapter1=new CustomAdapter1(getSupportFragmentManager(),list);

        binding.viewPager.setAdapter(customAdapter);

        binding.tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewPager.setCurrentItem(0);
            }
        });

        binding.tvSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewPager.setCurrentItem(1);
            }
        });


    }


}

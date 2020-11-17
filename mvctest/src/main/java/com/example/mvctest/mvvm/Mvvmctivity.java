package com.example.mvctest.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mvctest.R;
import com.example.mvctest.databinding.ActivityMvvmctivityBinding;

public class Mvvmctivity extends AppCompatActivity {

    ActivityMvvmctivityBinding binding;

    NumViewModel numViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvmctivity);

        binding = DataBindingUtil.setContentView(Mvvmctivity.this, R.layout.activity_mvvmctivity);

        numViewModel=new NumViewModel();

        binding.setViewModel(numViewModel);
//        numViewModel.getNum().observe(this,(num)->{
//            binding.tvShow.setText(num+"");
//        });

    }
}
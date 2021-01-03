package com.example.myfrgment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import com.example.myfrgment.databinding.ActivityReplaceBinding;

public class ReplaceActivity extends AppCompatActivity {


    ActivityReplaceBinding binding;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    HomeFragment homeFragment=new HomeFragment();
    SetFragment setFragment=new SetFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_replace);
        binding.tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(0);
            }
        });

        binding.tvSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(1);
            }
        });
    }

    public void replace(int type){
        if(fragmentManager==null){
            fragmentManager=getSupportFragmentManager();
        }
        fragmentTransaction=fragmentManager.beginTransaction();

        if(type==0){
            fragmentTransaction.replace(R.id.content,homeFragment);
        }else{
            fragmentTransaction.replace(R.id.content,setFragment);
        }
        fragmentTransaction.commit();

    }
}
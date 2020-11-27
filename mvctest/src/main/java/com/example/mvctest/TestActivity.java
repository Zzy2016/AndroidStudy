package com.example.mvctest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    ViewPager vp;
    TabLayout tl;

    List<Fragment> list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        vp = findViewById(R.id.vp);
        tl = findViewById(R.id.tl);


        list = new ArrayList<>();
        list.add(new BlankFragment());
        list.add(new BlankFragment());
        list.add(new BlankFragment());
        list.add(new BlankFragment());

        adapter = new CustomAdapter(getSupportFragmentManager(), list);

        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);


    }


    class CustomAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;
        private String[] title = {"one", "two", "three", "four"};

        public CustomAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

}
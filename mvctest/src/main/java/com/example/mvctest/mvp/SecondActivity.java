package com.example.mvctest.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvctest.R;


/*
* Activity --> view
* presenter --> p
* model --> model
*
* view<====>presenter--->model
* */
public class SecondActivity extends AppCompatActivity implements IView {


    TextView tvShow, tvAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvShow = findViewById(R.id.tvShow);
        tvAdd = findViewById(R.id.tvAdd);


    }

    @Override
    public void updateUI(String text) {
        tvShow.setText(text);
    }
}
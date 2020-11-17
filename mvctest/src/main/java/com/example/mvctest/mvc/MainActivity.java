package com.example.mvctest.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mvctest.R;


/*
* XML --> view
* MainModel -->model
* MainActivity --> controller
* */
public class MainActivity extends AppCompatActivity {

    TextView tvShow, tvAdd;
    MainModel mainModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = findViewById(R.id.tvShow);
        tvAdd = findViewById(R.id.tvAdd);
        mainModel = new MainModel();

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainModel.add(MainActivity.this);
            }
        });

    }

    public void updateUI(String num) {
        tvShow.setText(num);
    }
}

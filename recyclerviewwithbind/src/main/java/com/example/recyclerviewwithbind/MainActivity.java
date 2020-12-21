package com.example.recyclerviewwithbind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerviewwithbind.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    public final ObservableArrayList<Student> showDatas = new ObservableArrayList<Student>();

    private ActivityMainBinding binding;
    private List<Student> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        for (int i = 0; i < 200; i++) {
            list.add(new Student("student" + i));
        }
        showDatas.addAll(list);
        binding.setActivity(this);

    }

    public void onBindItem(ViewDataBinding binding, final Object data, int position) {
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class Student {

        public Student(String name) {
            this.name = name;
        }

        public String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

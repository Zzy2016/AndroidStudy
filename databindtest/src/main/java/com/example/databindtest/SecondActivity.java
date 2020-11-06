package com.example.databindtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ViewDataBinding;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.TextView;

import com.example.databindtest.databinding.ActivityMainBindingImpl;
import com.example.databindtest.databinding.ActivitySecondBinding;
import com.example.databindtest.generated.callback.OnClickListener;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {


    ViewDataBinding binding;


    //可观察数据对象
    ObservableArrayMap<String, Object> users = new ObservableArrayMap<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);


        users.put("firstName", "google");
        users.put("lastName", "inc");
        users.put("age", 17);


//        final User1 user1 = new User1();
//        user1.firstName.set("");

        User user1=new User("小明","123");

//        binding.setUser1(user1);
//        binding.setOnclick(new Click());


        binding.setVariable(BR.user,user1);





    }

    public class Click {
        public void onClickTest(User user1) {
//            user1.firstName.set(System.currentTimeMillis() + "");
            user1.setFirstName(System.currentTimeMillis()+" ");
        }
    }


}

package com.example.logintest;

import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.logintest.databinding.ActivityMainBinding;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//可观察数据类
//LiveData
//ViewModel

public class MVVMViewModel extends ViewModel {
    private ActivityMainBinding binding;
    private MVVMModel mvvmModel;
    private String input;
//    private String result;

    private ObservableField<String> result = new ObservableField<>();

//    private MutableLiveData<String> loginResult = new MutableLiveData<>();

    public ObservableField<String> getResult() {
        if (result == null) {
            result.set("123");
        }
        return result;
    }

    public void setResult(ObservableField<String> result) {
        this.result = result;
    }


    public MVVMViewModel(ActivityMainBinding binding) {
        this.binding = binding;
        this.mvvmModel = new MVVMModel();
    }


    public void getData(View view) {

        Log.e("-----------", "click");
        mvvmModel.getAccountData(binding.etAccount.getText().toString(), new MCallback() {
            @Override
            public void onSuccess(String result1) {
                result.set(result1);
            }

            @Override
            public void onFailed(String error1) {
                result.set(error1);
            }
        });
    }

    //    vcode passwordMD5 osName version  phone
    public void doLogin(View view) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("phone", "17635663998");
            jsonObject.put("osName", "Android");
            jsonObject.put("passwordMD5", binding.etPwd.getText().toString());
            jsonObject.put("version", "v2.1.1");
        }catch (Exception e){

        }



        mvvmModel.doLogin(jsonObject, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.e("登录1", "");
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("登录0", t.toString());
            }
        });
    }

}

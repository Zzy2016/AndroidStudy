package com.example.mvctest.mvvm;

import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvctest.BR;

public class NumViewModel extends BaseObservable {


    MutableLiveData<Integer> num = new MutableLiveData<>();
    //    public int test=0;
    public ObservableInt test = new ObservableInt();

    private final NumModel numModel;


    public NumViewModel() {
        this.numModel = new NumModel();

    }


    public MutableLiveData<Integer> getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num.postValue(num);
    }

    public void onClickAdd(View view) {
        numModel.add(new NumModel.ModelCallback() {
            @Override
            public void onSuccess(int num1) {
                Log.e("----------num",num1+"");
               setNum(num1);
                Log.e("----------num1",getNum().getValue()+"");
                test.set(num1);
            }

            @Override
            public void onFailed(String text) {

            }
        });

//        test.set(test+=1);
//        Log.e("----------num1", test + "");
    }
}

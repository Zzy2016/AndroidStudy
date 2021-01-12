package com.example.androidstudy.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<DB extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity {

    public DB mDataBinding;
    protected VM mViewModel;




}

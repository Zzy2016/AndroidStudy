package com.example.databindtest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class TestSelect {
    public MutableLiveData<Boolean> isSelect = new MutableLiveData<>();

    public TestSelect(boolean isSelect) {
        this.isSelect.setValue(isSelect);
    }


}

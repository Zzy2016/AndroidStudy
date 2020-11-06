package com.example.bindrecyclerview;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;

/**
 * @author: Administrator
 * @date: 2020/11/6
 */
class LoginViewModel extends BaseObservable {
    ObservableBoolean rememberMe;

    @Bindable
    public ObservableBoolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(ObservableBoolean rememberMe) {
        
        this.rememberMe = rememberMe;
    }
}

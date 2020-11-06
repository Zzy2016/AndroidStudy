package com.example.databindtest;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author: Administrator
 * @date: 2020/11/6
 */
public class Student extends BaseObservable {
    private String firstName;
    private String lastName;

    @Bindable
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

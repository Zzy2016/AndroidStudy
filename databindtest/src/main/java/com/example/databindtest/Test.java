package com.example.databindtest;

import androidx.databinding.ObservableField;

public class Test {
    public ObservableField<String> name = new ObservableField<>();

    public Test(String name) {
        this.name.set(name);
    }
}

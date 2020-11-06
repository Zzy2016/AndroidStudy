package com.example.databindtest;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * @author: Administrator
 * @date: 2020/11/6
 */
public class User1 {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}

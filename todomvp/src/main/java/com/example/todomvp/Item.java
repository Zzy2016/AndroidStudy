package com.example.todomvp;

import androidx.lifecycle.MutableLiveData;

public class Item {

    public MutableLiveData<String> title;
    public MutableLiveData<String> content;
    public MutableLiveData<String> time;
    public MutableLiveData<Boolean> isCheck;

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public void setTitle(MutableLiveData<String> title) {
        this.title = title;
    }

    public MutableLiveData<String> getContent() {
        return content;
    }

    public void setContent(MutableLiveData<String> content) {
        this.content = content;
    }

    public MutableLiveData<String> getTime() {
        return time;
    }

    public void setTime(MutableLiveData<String> time) {
        this.time = time;
    }

    public MutableLiveData<Boolean> getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(MutableLiveData<Boolean> isCheck) {
        this.isCheck = isCheck;
    }
}

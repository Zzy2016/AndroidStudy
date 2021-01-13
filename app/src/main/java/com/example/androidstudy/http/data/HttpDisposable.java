package com.example.androidstudy.http.data;

import io.reactivex.observers.DisposableObserver;

//返回数据
public abstract class HttpDisposable<T> extends DisposableObserver<T> {
    public HttpDisposable(){

    }

    @Override
    protected void onStart() {

    }

    @Override
    public void onNext(T t) {
        success(t);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    public abstract void success(T t);
}

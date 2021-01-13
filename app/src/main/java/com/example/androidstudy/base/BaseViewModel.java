package com.example.androidstudy.base;

import android.content.res.Resources;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidstudy.config.App;
import com.example.androidstudy.config.LoadState;
import com.example.androidstudy.http.data.HttpDisposable;
import com.example.androidstudy.http.request.HttpFactory;
import com.example.androidstudy.http.request.HttpRequest;

import retrofit2.Response;

public abstract class BaseViewModel extends ViewModel implements DefaultLifecycleObserver {

    public Resources resources;

    /*收藏文章*/
    public MutableLiveData<Object> collect=new MutableLiveData<>();

    /*加载状态*/
    public MutableLiveData<LoadState> loadState=new MutableLiveData<>();


    public MutableLiveData<String> errorMsg=new MutableLiveData<>();

    /*是否刷新数据*/
    public boolean mRefresh;

    /*重新加载数据 没有网络 点击重试时回调*/

    public void reloadData(){

    }



    public Resources getResources(){
        if(resources==null){
            resources= App.getContext().getResources();
        }
        return resources;
    }

    /*改变文章收藏状态*/
    public void changeArticleCollect(boolean collect,int id){
        if(collect){
            collectArticle(id);
        }else{
            unCollectArticle(id);
        }
    }

    public LiveData<Object> getCollectStatus(){
        return collect;
    }

    /*收藏文章*/
    private void collectArticle(int id){
        HttpRequest.getInstance().collectArticle(id)
                .compose(HttpFactory.schedules())
                .subscribe(new HttpDisposable<Object>() {
                    @Override
                    public void success(Object o) {
                        collect.postValue(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        collect.postValue(null);
                    }
                });
    }

    /*取消收藏文章*/
    private void unCollectArticle(int id){
        HttpRequest.getInstance().unCollectArticle(id)
                .compose(HttpFactory.schedules())
                .subscribe(new HttpDisposable<Object>() {
                    @Override
                    public void success(Object o) {
                        collect.postValue(o);
                    }
                });
    }

}

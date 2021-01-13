package com.example.androidstudy.ui.activity.splash;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidstudy.R;
import com.example.androidstudy.base.BaseViewModel;
import com.example.androidstudy.bean.ActivitySkip;
import com.example.androidstudy.bean.reponsebean.ImageBean;
import com.example.androidstudy.http.data.HttpDisposable;
import com.example.androidstudy.http.request.HttpFactory;
import com.example.androidstudy.http.request.HttpRequest;
import com.example.androidstudy.http.request.ServerAddress;
import com.example.androidstudy.util.NetworkUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class SplashViewModel extends BaseViewModel {

    private MutableLiveData<ImageBean> mImage;
    private MutableLiveData<String> mTimer;
    private MutableLiveData<ActivitySkip> mActivitySkip;
    private String url;

    public SplashViewModel() {
        mActivitySkip=new MutableLiveData<>();
        mImage=new MutableLiveData<>();
        mTimer=new MutableLiveData<>();
        mTimer.postValue("跳过："+"5S");
    }

   public LiveData<ImageBean> getImageData(){
        return mImage;
   }


   public LiveData<String> getTimer(){
        return mTimer;
   }

   public LiveData<ActivitySkip> getActivitySkip(){
        return mActivitySkip;
   }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);
        startTimer();
        loadImageView();

    }

    /*获取每日图片*/
    public void loadImageView(){
        if(!NetworkUtils.isConnected()){
            mImage.postValue(null);
        }else{
            HttpRequest.getInstance(ServerAddress.API_BING)
                    .getImage("js",0,1)
                    .compose(HttpFactory.<ImageBean>schedules())
                    .subscribe(new HttpDisposable<ImageBean>() {
                        @Override
                        public void success(ImageBean imageBean) {
                            mImage.postValue(imageBean);
                            url=imageBean.getImages().get(0).getCopyrightlink();
                        }

                        @Override
                        public void onError(Throwable e) {
                           mImage.postValue(null);
                        }
                    });
        }

    }

    public void startTimer(){
        List<String> list=new ArrayList<>();
        for(int i=4;i>=0;i--){
            list.add(i+"s");
        }
        Observable<String> observable=Observable.fromIterable(list);
        Observable<Long> time=Observable.interval(1, TimeUnit.SECONDS);
        Observable.zip(observable, time, new BiFunction<String, Long, String>() {
            @Override
            public String apply(String s, Long aLong) throws Exception {
                return s;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                if ((getResources().getString(R.string.time_0)).equals(s)) {
                    startMainActivity();
                }
                mTimer.postValue(getResources().getString(R.string.skip) + s);
            }
        });
    }

    /*打开主页*/
    public void startMainActivity(){
        ActivitySkip activitySkip=new ActivitySkip();
        activitySkip.setmActivity("MainActivity");
        mActivitySkip.postValue(activitySkip);

    }

    /*打开每日详情*/
    public void startSplashImageDetail(){
        ActivitySkip activitySkip=new ActivitySkip();
        activitySkip.setmActivity("DetailsActivity");
        activitySkip.setParam1(url);
        mActivitySkip.postValue(activitySkip);
    }


    @Override
    public void onStart(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

    }
}

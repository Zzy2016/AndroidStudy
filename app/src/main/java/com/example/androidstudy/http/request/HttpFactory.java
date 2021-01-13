package com.example.androidstudy.http.request;

import com.example.androidstudy.http.data.HttpResponseInterface;
import com.example.androidstudy.http.httptool.AddCookiesInterceptor;
import com.example.androidstudy.http.httptool.HttpInterceptor;
import com.example.androidstudy.http.httptool.ResponseConverterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class HttpFactory {
    public static String HTTP_HOST_URL="";
    public static HttpResponseInterface httpResponseInterface=null;

    private HttpFactory(){

    }

    private static OkHttpClient HTTP_CLIENT=new OkHttpClient.Builder().addInterceptor(new HttpInterceptor())
            .addInterceptor(new AddCookiesInterceptor())
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .build();

    private static Retrofit retrofit=null;

    public static <T> T getChangeUrlInstance(String url,Class<T> service){
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(ResponseConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(HTTP_CLIENT)
                .build()
                .create(service);
    }

    public static <T> T getInstance(Class<T> service){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(HTTP_HOST_URL)
                    .addConverterFactory(ResponseConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(HTTP_CLIENT)
                    .build();
        }
        return retrofit.create(service);
    }

    public static <T>ObservableTransformer<T,T> schedules(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


}

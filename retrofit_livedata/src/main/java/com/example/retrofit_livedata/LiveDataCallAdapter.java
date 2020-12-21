package com.example.retrofit_livedata;

import androidx.lifecycle.LiveData;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<T> implements CallAdapter<T, LiveData<T>> {
    private Type mResponseType;
    private boolean isApiResponse;

    public LiveDataCallAdapter(Type mResponseType, boolean isApiResponse) {
        this.mResponseType = mResponseType;
        this.isApiResponse = isApiResponse;
    }

    @Override
    public Type responseType() {
        return mResponseType;
    }

    @Override
    public LiveData<T> adapt(Call<T> call) {
        return new MyLiveData<>(call,isApiResponse);
    }


    private static class MyLiveData<T> extends LiveData<T> {
        private AtomicBoolean stared = new AtomicBoolean(false);
        private final Call<T> call;
        private boolean isApiResponse;

        public MyLiveData(Call<T> call, boolean isApiResponse) {
            this.call = call;
            this.isApiResponse = isApiResponse;
        }

        @Override
        protected void onActive() {
            super.onActive();
            if (stared.compareAndSet(false, true)) {
                call.enqueue(new Callback<T>() {
                    @Override
                    public void onResponse(Call<T> call, Response<T> response) {
                        T body = response.body();
                        postValue(body);
                    }

                    @Override
                    public void onFailure(Call<T> call, Throwable t) {
                        if (isApiResponse) {
                            postValue((T) new ApiResponse<>(ApiResponse.CODE_ERROR, t.getMessage()));
                        } else {
                            postValue(null);
                        }
                    }
                });
            }
        }
    }

}

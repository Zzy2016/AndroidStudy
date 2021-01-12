package com.example.imageloader;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    static class MyHandler extends Handler {
        //创建一个类继承 Handler
        WeakReference<AppCompatActivity> mWeakReference;

        public MyHandler(AppCompatActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        //在 handleMessage 方法中对网络下载的图片进行处理
        @Override
        public void handleMessage(Message msg) {
            final AppCompatActivity appCompatActivity = mWeakReference.get();
            if (appCompatActivity != null) {
//                switch (msg.what) {
//                    case SUCCESS://成功
//                        byte[] Picture = (byte[]) msg.obj;
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(Picture, 0, Picture.length);
//                        mImageLoader.addBitmap(ImageUtils.hashKeyForCache(imgUrl), bitmap);
//                        mImageView.setImageBitmap(bitmap);
//
//                        break;
//                    case FAIL://失败
//
//                        break;
//                }

            }
        }
    }

}

package com.example.aboutwidget;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AppWidgetManager appWidgetManager = getSystemService(AppWidgetManager.class);
//        ComponentName myProvider = new ComponentName(MainActivity.this, MyAppWidgetProvider.class);
//        if (appWidgetManager.isRequestPinAppWidgetSupported()) {
//            Intent intent = new Intent();
//            PendingIntent successCallback = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
//            appWidgetManager.requestPinAppWidget(myProvider, null, successCallback);
//        }



    }


}

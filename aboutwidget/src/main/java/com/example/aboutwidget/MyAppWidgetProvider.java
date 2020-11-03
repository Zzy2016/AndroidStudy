package com.example.aboutwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * @author: Administrator
 * @date: 2020/11/3
 */
public class MyAppWidgetProvider extends AppWidgetProvider {




    private static final String TAG = "MyAppWidgetProvider";
    private static final String CLICK_ACTION = "com.example.aboutwidget.CLICK";

    public MyAppWidgetProvider() {
        super();
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        super.onReceive(context, intent);

        Log.e(TAG, "onReceive: action    " + intent.getAction());
        //这里是判断自己的action，做自己的事情，比如小部件点击了要干什么，这里是做一个动画效果
        if (intent.getAction().equals(CLICK_ACTION)){
            Toast.makeText(context, "Clicked it", Toast.LENGTH_SHORT).show();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    Bitmap srcbBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.like);
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    for (int i = 0; i < 37; i++) {
                        float degree = (i * 10) % 360;
                        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.back);
                        remoteViews.setImageViewBitmap(R.id.img,rotateBitmap(context,srcbBitmap,degree));
//                        Intent intentClick = new Intent();
//                        intentClick.setAction(CLICK_ACTION);
//                        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intentClick,0);
//                        remoteViews.setOnClickPendingIntent(R.id.img,pendingIntent);
                        appWidgetManager.updateAppWidget(new ComponentName(context,MyAppWidgetProvider.class),remoteViews);
                        SystemClock.sleep(300);
                    }
                }
            }).start();
        }

    }

    //小部件更新时调用
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.e(TAG, "onUpdate: ");
        final int counter = appWidgetIds.length;
        Log.e(TAG, "counter =  " + counter);
        for (int i = 0; i < counter; i++) {
            int appWidgetId = appWidgetIds[i];
            onAppWidgetUpdate(context,appWidgetManager,appWidgetId);
        }
    }

    private Bitmap rotateBitmap(Context context, Bitmap srcbBitmap, float degree) {
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        Bitmap tmpBitmap = Bitmap.createBitmap(srcbBitmap,0,0,srcbBitmap.getWidth(),srcbBitmap.getHeight(),matrix,true);
        return tmpBitmap;
    }

    //桌面小部件更新
    private void onAppWidgetUpdate(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        Log.e(TAG, "appWidgetId=" + appWidgetId);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.back);
//        //“桌面小部件” 点击事件发送的intent广播
//        Intent intentClick = new Intent(context,MyAppWidgetProvider.class);
//        intentClick.setAction(CLICK_ACTION);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intentClick,0);
//        remoteViews.setOnClickPendingIntent(R.id.img,pendingIntent);

        Intent intentClick = new Intent(context, MainActivity.class);
        intentClick.setAction(CLICK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intentClick, 0);
        remoteViews.setOnClickPendingIntent(R.id.img, pendingIntent);

        appWidgetManager.updateAppWidget(new ComponentName(context,MyAppWidgetProvider.class),remoteViews);
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
        Log.e(TAG, "onRestored" );
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.e(TAG, "onEnabled" );
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.e(TAG, "onDisabled" );
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.e(TAG, "onDeleted" );
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        Log.e(TAG, "onAppWidgetOptionsChanged" );
    }
}

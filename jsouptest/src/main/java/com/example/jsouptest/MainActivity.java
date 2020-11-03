package com.example.jsouptest;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.IOException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    WebView webview;

    Button button;

    private int widthPixels = 0;
    private int heightPixels = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        widthPixels = outMetrics.widthPixels;
        heightPixels = outMetrics.heightPixels;
        webview = (WebView) findViewById(R.id.webView);
        button = (Button) findViewById(R.id.button);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.addJavascriptInterface(MainActivity.this, "android");
//        webview.getSettings().setUseWideViewPort(true); //将图片调整到适合webview的大小
        webview.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
//        webview.getSettings().setSupportZoom(true);

        webview.setBackgroundColor(0); // 设置背景色
        webview.getBackground().setAlpha(0); // 设置填充透明度 范围：0-255

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

//        int screenDensity = getResources().getDisplayMetrics().densityDpi;
//        WebSettings.ZoomDensity zoomDensity = WebSettings.ZoomDensity.MEDIUM;
//        switch (screenDensity) {
//            case DisplayMetrics.DENSITY_LOW:
//                zoomDensity = WebSettings.ZoomDensity.CLOSE;
//                break;
//            case DisplayMetrics.DENSITY_MEDIUM:
//                zoomDensity = WebSettings.ZoomDensity.MEDIUM;
//                break;
//            case DisplayMetrics.DENSITY_HIGH:
//            case DisplayMetrics.DENSITY_XHIGH:
//            case DisplayMetrics.DENSITY_XXHIGH:
//            default:
//                zoomDensity = WebSettings.ZoomDensity.FAR;
//                break;
//        }
//        zoomDensity = WebSettings.ZoomDensity.CLOSE;
//        webview.getSettings().setDefaultZoom(zoomDensity);

        webview.getSettings().setTextZoom(100);
        webview.setInitialScale(200);

        webview.loadUrl("file:///android_asset/test.html");
        ViewGroup.LayoutParams params = webview.getLayoutParams();
        params.width = widthPixels;
        params.height = heightPixels;
        webview.setLayoutParams(params);
        Log.e("width-height", widthPixels + "  " + heightPixels);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//            }
//        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Log.e("------------", data.getStringExtra("verify"));
        }
    }

    @JavascriptInterface
    public void showLog(String result) {
        Log.e("验证码-----------", result);
//        webview.setVisibility(View.GONE);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams params = webview.getLayoutParams();
                params.width = 0;
                params.height = 0;
                webview.setLayoutParams(params);
            }
        });
    }


}

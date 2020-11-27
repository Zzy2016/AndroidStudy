package com.example.webview1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        btn = findViewById(R.id.btn);
        webView.getSettings().setJavaScriptEnabled(true);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                testJS();
            }
        });

        webView.loadUrl("file:///android_asset/dist/views/pages/diagnosisHistory.html");




    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void testJS() {
//        webView.post(new Runnable() {
//            @Override
//            public void run() {
//                webView.loadUrl("javascript:getPrimordialValue('123------>')");
//            }
//        });

        webView.evaluateJavascript("javascript:getPrimordialValue('123------>')", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {

            }
        });
    }
}

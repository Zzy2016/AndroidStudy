package com.example.webview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

public class ThriedActivity extends AppCompatActivity {

    BridgeWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thried);

        webView = findViewById(R.id.webView1);

        webView.loadUrl("file:///android_asset/dist/views/pages/diagnosisReport.html");



        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.callHandler("getAndroidValue", "123", new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {
                        Log.e("t--------", "来自web的回传数据：" + data);
                    }
                });
            }
        });

    }
}
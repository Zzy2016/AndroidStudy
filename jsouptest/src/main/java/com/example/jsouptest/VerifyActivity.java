package com.example.jsouptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class VerifyActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_verify);

        webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/test.html");
        webView.addJavascriptInterface(VerifyActivity.this,"android");
    }


    @JavascriptInterface
    public void showLog(final String result) {
        Log.e("-----------", result);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent();
                intent.putExtra("verify",result);
                setResult(1,intent);
                webView.destroy();
                finish();
            }
        });
    }

}

package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
//
//import com.bumptech.glide.Glide;
//import com.example.androidstudy.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

//    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        String path = "https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTItviaTuziacQEGrzqiaV3lMddYMCcBJWLibxeo1ia8sEPyiacibIOsLUmPdJQRHPvFYblBgoSiboznzRst4Q/132";

//        Glide.with(this).load(path).into(binding.img);

//        String path1 = "http://192.168.1.176:1185/user/weiXinUser/getWeChatBindingState";
//
//        @SuppressLint("ServiceCast") TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELECOM_SERVICE);
//
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        Log.e("----imei", telephonyManager.getDeviceId().toString());
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new LoggingInterceptor()).build();
//        FormBody formBody = new FormBody.Builder().add("openid", "").build();
//        OkHttpClient okHttpClient=new OkHttpClient();


//        Request request = new Request.Builder().url(path1).post(formBody).
//                header("Accept", "*/*").
//                header("Content-Type", "application/json").
////                header("accept", "application/json").
//        build();

//        Request request = new Request.Builder().url("http://www.baidu.com").get().build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                Log.e("----------", e.toString());
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                Log.e("----------", response.body().string());
//            }
//        });
//        call.enqueue();
//        try {
//            call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    OkHttpClient okHttpClient1 = new OkHttpClient();
//                    Request request = new Request.Builder().url("https://publicobject.com/helloworld.txt").build();
//                    Response response = okHttpClient1.newCall(request).execute();
//                    if (response.isSuccessful()) {
//                        Headers responseHeaders = response.headers();
//                        for (int i = 0; i < responseHeaders.size(); i++) {
//                            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                        }
//
//                        Log.e("-----------1", response.body().string());
//
//                    } else {
//                        Log.e("-----------2", "response.body().string()");
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();

    }

    class LoggingInterceptor implements Interceptor {


        public static final String TAG = "Http_log";

        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {

            Request request = chain.request();


            long t1 = System.nanoTime();
            Log.i(TAG + "0", String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            Log.i(TAG + "1", String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }
}

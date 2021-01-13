package com.example.androidstudy.http.httptool;

import android.util.Log;

import com.example.androidstudy.bean.reponsebean.LoginBean;
import com.example.androidstudy.config.Constants;
import com.example.androidstudy.util.NetworkUtils;
import com.orhanobut.hawk.Hawk;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class HttpInterceptor implements Interceptor {
    private static final Charset UTF8=Charset.forName("UTF-8");
    private static String REQUEST_TAG="请求";

    @Override
    public Response intercept(Chain chain) throws IOException {
        if(!NetworkUtils.isConnected()){
            throw new HttpException("网络链接异常，请检查网络后重试");
        }
        Response originalResponse=chain.proceed(chain.request());
        if(!originalResponse.headers("Set-Cookie").isEmpty()){
            HashSet<String> cookies=new HashSet<>();
            for(String header:originalResponse.headers("Set-Cookie")){
                cookies.add(header);
            }
            Hawk.put(Constants.HawkCode.COOKIE,cookies);
        }

        Request request=chain.request();
        request=getHeaderRequest(request);
        logRequest(request);
        Response response=chain.proceed(request);
        logResponse(response);
        return originalResponse;
    }


    /*添加Head*/
    public Request getHeaderRequest(Request request){
        LoginBean loginBean=Hawk.get(Constants.HawkCode.LOGIN_DATA);
        Request headRequest;
        if(loginBean!=null){
            headRequest=request.newBuilder()
                    .addHeader("token",loginBean.getToken())
                    .addHeader("Cookie","loginUserName="+loginBean.getUsername())
                    .addHeader("Cookie","loginUserPassword="+loginBean.getPassword())
                    .build();
        }else{
            headRequest=request.newBuilder()
                    .addHeader("platform","android")
                    .addHeader("version","1.0")
                    .build();
        }
        return headRequest;
    }

    /*打印请求信息*/
    public void logRequest(Request request){
        if(request.method().equals("GET")){
            return;
        }
        try{
            RequestBody requestBody=request.body();
            String parameter=null;
            Buffer buffer=new Buffer();
            requestBody.writeTo(buffer);
            parameter=buffer.readString(UTF8);
            buffer.flush();
            buffer.close();
            Log.d(REQUEST_TAG + "参数", parameter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*打印返回结果*/
    private void logResponse(Response response){
        try{
            ResponseBody responseBody=response.body();
            String rBody=null;
            BufferedSource source=responseBody.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer=source.buffer();
            Charset charset=UTF8;
            MediaType mediaType=responseBody.contentType();
            if(mediaType!=null){
                try{
                    charset=mediaType.charset(UTF8);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

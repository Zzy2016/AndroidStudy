//package com.example.imageloader;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Build;
//import android.os.Environment;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.os.Messenger;
//import android.os.StatFs;
//import android.util.LruCache;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.IOError;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.concurrent.Executor;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
//public class ImageLoader {
//    private static final String TAG="ImageLoader";
//    private static final int MESSAGE_POST_RESULT=1;
//    private static final int CPU_COUNT=Runtime.getRuntime().availableProcessors();
//    private static final int CORE_POOL_SIZE=CPU_COUNT+1;
//    private static final int MAXIMUM_POOL_SIZE=CPU_COUNT*2+1;
//    private static final long KEEP_ALIVE=10L;
//    private static final int TAG_KEY_URI=0;
//    private static final int DISK_CACHE_SIZE=1024*1024*50;
//    private static final int IO_BUFFER_SIZE=8*1024;
//    private static final int DISK_CACHE_INDEX=0;
//    private boolean mIsDiskLruCacheCreate=false;
//
//    private static final ThreadFactory sThreadFactory=new ThreadFactory() {
//
//        private final AtomicInteger mCount=new AtomicInteger(1);
//
//        @Override
//        public Thread newThread(Runnable runnable) {
//            return new Thread(runnable,"ImageLoader#"+mCount.getAndIncrement());
//        }
//    };
//
//    public static final Executor THREAD_POOL_EXECUTOR=new ThreadPoolExecutor(CORE_POOL_SIZE,MAXIMUM_POOL_SIZE,KEEP_ALIVE, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),sThreadFactory);
//    private Handler mMainHandler=new android.os.Handler(){
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//
//
//
//        }
//    };
//
//    private Context context;
//    private ImageResizer imageResizer=new ImageResizer();
//    private LruCache<String,Bitmap> mMemoryCache;
//    private DiskLruCache mDiskLruCache;
//
//
//
//
//    public ImageLoader(Context context) {
//        context=context.getApplicationContext();
//        int maxMemory=(int)(Runtime.getRuntime().maxMemory()/1024);
//        int cacheSize=maxMemory/8;
//        mMemoryCache=new LruCache<String,Bitmap>(cacheSize){
//            @Override
//            protected int sizeOf(String key, Bitmap value) {
//                return value.getRowBytes()*value.getHeight()/1024;
//            }
//        };
//        File diskCacheFile=getDiskCacheDir(context,"bitmap");
//        if(!diskCacheFile.exists()){
//            diskCacheFile.mkdirs();
//        }
//
//        if(getUsableSpace(diskCacheFile)>DISK_CACHE_SIZE){
//
//        }
//
//    }
//
//    public static ImageLoader build(Context context){
//        return new ImageLoader(context);
//    }
//
//    private void addBitmapToMemoryCache(String key,Bitmap bitmap){
//
//    }
//
//    private Bitmap getBitmapFromMemCache(String key){
//        return mMemoryCache.get(key);
//    }
//
//    private void bindBitmap(final String uri,final ImageView imageView){
//
//    }
//
//    private void bindBitmap(final String uri,final ImageView imageView,final int reqWidth,final int reqHeight){
//
//    }
//
//    private Bitmap loadBitmap(String uri,int reqWidth,int reqHeight){
//
//    }
//
//    private Bitmap loadBitmapFromMemCache(String url){
//        final String key=hashKeyFromUrl(url);
//        Bitmap bitmap=getBitmapFromMemCache(key);
//        return bitmap;
//    }
//
//    private Bitmap loadBitmapFromHttp(String url,int reqWidth,int reqHeight) throws IOException {
//        if(Looper.myLooper()==Looper.getMainLooper()){
//
//        }
//        if(mDiskLruCache==null){
//
//        }
//
//        String key=hashKeyFormUrl(url);
////        DiskLruCache.Editor editor=mDiskLruCache.edit(key);
////        if(editor!=null){
////            OutputStream outputStream=editor.newOutputStream(DISK_CACHE_INDEX);
////            if(downloadUrlToStream(url,outputStream)){
////                editor.commit();
////            }else{
////                editor.abort();
////            }
////            mDiskLruCache.flush();
////        }
////
////        return
//
//        return null;
//    }
//
//    private String hashKeyFromUrl(String url){
//        String cacheKey;
//        try {
//            final MessageDigest mDigest=MessageDigest.getInstance("MD5");
//
//        }catch (Exception e){
//
//        }
//        return cacheKey;
//    }
//
//
//
//
//    private Bitmap loadBitmapFromDiskCache(String url,int reqWidth,int reqHeight)throws IOException{
//        if(Looper.myLooper()==Looper.getMainLooper()){
//
//        }
//
//        if(mDiskLruCache==null){
//            return null;
//        }
//
//        Bitmap bitmap=null;
//
//        String key=hashKeyFormUrl(url);
//
//
//
//    }
//
//    public boolean downloadUrlToStream(String urlString,OutputStream outputStream){
//        HttpURLConnection urlConnection=null;
//        BufferedOutputStream out=null;
//        BufferedInputStream in=null;
//        try{
//            final URL url=new URL(urlString);
//            urlConnection= (HttpURLConnection) url.openConnection();
//            in=new BufferedInputStream(urlConnection.getInputStream(),IO_BUFFER_SIZE);
//            out=new BufferedOutputStream(outputStream,IO_BUFFER_SIZE);
//
//            int b;
//            while ((b=in.read())!=-1){
//                out.write(b);
//            }
//            return true;
//
//        }catch (Exception e){
//
//        }finally {
//            if(urlConnection!=null){
//                urlConnection.disconnect();
//            }
//
//        }
//        return false;
//    }
//
//    private Bitmap downloadBitmapFromUrl(String urlString){
//        Bitmap bitmap=null;
//        HttpURLConnection urlConnection=null;
//        BufferedInputStream in=null;
//        try{
//            final URL url=new URL(urlString);
//            urlConnection= (HttpURLConnection) url.openConnection();
//            in=new BufferedInputStream(urlConnection.getInputStream(),IO_BUFFER_SIZE);
//            bitmap= BitmapFactory.decodeStream(in);
//        }catch (Exception e){
//
//        }finally {
//            if(urlConnection!=null){
//                urlConnection.disconnect();
//            }
//
//        }
//        return bitmap;
//    }
//
//
//    private String hashKeyFormUrl(String url){
//        String cacheKey;
//        try{
//            final MessageDigest messageDigest=MessageDigest.getInstance("MD5");
//            messageDigest.update(url.getBytes());
//            cacheKey=bytesToHexString(messageDigest.digest());
//        }catch (NoSuchAlgorithmException e){
//            cacheKey=String.valueOf(url.hashCode());
//        }
//        return cacheKey;
//    }
//
//    private String bytesToHexString(byte[] bytes){
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<bytes.length;i++){
//            String hex=Integer.toHexString(0xFF&bytes[i]){
//                if(hex.length()==1){
//                    sb.append('0');
//                }
//                sb.append(hex);
//            }
//        }
//        return sb.toString();
//    }
//
//    public File getDiskCacheDir(Context context,String uniqueName){
//        boolean externalStorageAvailable= Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
//        final String cachePath;
//        if(externalStorageAvailable){
//            cachePath=context.getExternalCacheDir().getPath();
//        }else {
//            cachePath=context.getCacheDir().getPath();
//        }
//        return new File(cachePath+File.separator+uniqueName);
//    }
//
//
//    private long getUsableSpace(File file){
//        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.GINGERBREAD){
//            return file.getUsableSpace();
//        }
//        final StatFs statFs=new StatFs(file.getPath());
//        return statFs.getBlockSize()*statFs.getAvailableBlocks();
//    }
//
//    private static class LoaderResult{
//        public ImageView imageView;
//        public String url;
//        public String bitmap;
//
//        public LoaderResult(ImageView imageView, String url, String bitmap) {
//            this.imageView = imageView;
//            this.url = url;
//            this.bitmap = bitmap;
//        }
//    }
//}

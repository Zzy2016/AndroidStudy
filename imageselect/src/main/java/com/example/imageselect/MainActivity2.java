package com.example.imageselect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.os.Environment.DIRECTORY_PICTURES;

public class MainActivity2 extends AppCompatActivity {


    private String[] permissions = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
            , Manifest.permission.WRITE_EXTERNAL_STORAGE
            , Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        ActivityCompat.requestPermissions(this, permissions, 1);


        createImg();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    //getFilesDir  /data/user/0/com.example.imageselect/files
    //getCacheDir  /data/user/0/com.example.imageselect/cache
    //getExternalFilesDir  /storage/emulated/0/Android/data/com.example.imageselect/files
    //getExternalCacheDir  /storage/emulated/0/Android/data/com.example.imageselect/cache
    public void createImg() {
        try {
            Log.e("文件 1", getFilesDir().getAbsolutePath());
            Log.e("文件2 ", getExternalFilesDir("").getAbsolutePath());
            Log.e("文件 3", getCacheDir().getAbsolutePath());
            Log.e("文件 4", getExternalCacheDir().getAbsolutePath());
            Log.e("文件 5", Environment.getDataDirectory().getAbsolutePath());

            Log.e("文件 6", Environment.getExternalStorageDirectory().getAbsolutePath());

            File file = Environment.getExternalStorageDirectory();

            List<File> list = Arrays.asList(file.listFiles());
            for (File item : list) {
                Log.e("文件----", item.getAbsolutePath());
            }



//            File file1 = getFilesDir();
//            Log.e("文件  ", file1.getAbsolutePath() + "  " + file1.exists());
//            File file2 = new File(file1, "123.jpg");
//            File file3 = new File(file1, "123456.jpg");
//            File file4 = new File(file1, "123456789.jpg");
//            Log.e("文件 ", file2.exists() + "file2");
//            file2.createNewFile();
//            file3.createNewFile();
//            file4.createNewFile();
//            Log.e("文件 ", file2.exists() + "file211");

//            File[] files = file1.listFiles();

//            for (File item : files) {
//                Log.e("内部粗出", item.getAbsolutePath() + "  " + item.length());
//            }

        } catch (Exception e) {
            Log.e("image---", e.toString());
        }


    }
}
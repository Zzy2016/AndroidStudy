package com.example.imageselect;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.imageselect.adapter.ImageShowIconAdapter;
import com.example.imageselect.adapter.ImageSelectAdapter;
import com.example.imageselect.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Image> list;
    private ActivityMainBinding binding;
    private int MAX = 5;
    private ImageSelectAdapter imgAdapter;
    private ImageShowIconAdapter imageShowIconAdapter;
    private List<ImageModel> imageModels = new ArrayList<>();
    private List<Image> imageSelect = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getPackageName() + "/cache/icon/";
        Log.e("lujing", Environment.getExternalStorageDirectory().getAbsolutePath());

        MAX = getIntent().getIntExtra("max", 5);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        modifyClick();

        binding.tvTitle.setText("选择图片");
        list = new ArrayList<>();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            getImage();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }


        imageShowIconAdapter = new ImageShowIconAdapter(MainActivity.this);
        imageShowIconAdapter.setOnCallBack(new ImageShowIconAdapter.onCallBack() {
            @Override
            public void onChange(String path) {
                binding.vpImage.setCurrentItem(imageSelect.indexOf(path), false);
            }
        });

        binding.tvCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (MAX == 1) {
//                    if (binding.clImgBig.getVisibility() == View.VISIBLE) {
//                        Intent intent = new Intent();
//                        intent.putExtra("IMAGE_FROM_ALBUM", list.get(binding.vpImage.getCurrentItem()));
//                        setResult(0, intent);
//                    }
//                    finish();
                }

                if (imgAdapter.getSelectList().size() > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("IMAGE_FROM_ALBUM", imgAdapter.getSelectList().toString());
                    setResult(0, intent);
                }
                finish();
            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.clImgBig.getVisibility() == View.VISIBLE) {
                    binding.clImgBig.setVisibility(View.GONE);

//                    imgAdapter.setSelectList(imageSelect);
//                    imgAdapter.setImageModels(imageModels);
                    imgAdapter.notifyDataSetChanged();
                    modifyClick();
                } else {
                    finish();
                }
            }
        });


    }

    public void modifyClick() {
        if (MAX == 1) {
            if (binding.clImgBig.getVisibility() == View.VISIBLE) {
                binding.tvCount.setBackgroundResource(R.drawable.back_btn_greent);
                binding.tvCount.setEnabled(true);
            } else {
                binding.tvCount.setBackgroundResource(R.drawable.back_btn_gray);
                binding.tvCount.setEnabled(false);
            }
        } else {
            if (imageSelect.size() > 0) {
                binding.tvCount.setBackgroundResource(R.drawable.back_btn_greent);
                binding.tvCount.setEnabled(true);
            } else {
                binding.tvCount.setBackgroundResource(R.drawable.back_btn_gray);
                binding.tvCount.setEnabled(false);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getImage();
    }

    public void getImage() {

        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        ContentResolver mContentResolver = getContentResolver();

        Cursor mCursor = mContentResolver.query(mImageUri, new String[]{
                        MediaStore.Images.Media.DATA,
                        MediaStore.Images.Media.DISPLAY_NAME,
                        MediaStore.Images.Media.DATE_ADDED,
                        MediaStore.Images.Media._ID,
                        MediaStore.Images.Media.MIME_TYPE,
                        MediaStore.Images.Media.SIZE},
                MediaStore.MediaColumns.SIZE + ">0",
                null,
                MediaStore.Images.Media.DATE_ADDED + " DESC");


        if (mCursor != null) {
            while (mCursor.moveToNext()) {
                String path = mCursor.getString(
                        mCursor.getColumnIndex(MediaStore.Images.Media.DATA));
                long id = mCursor.getLong(mCursor.getColumnIndex(MediaStore.Images.Media._ID));
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon()
                        .appendPath(String.valueOf(id)).build();
                Image image = new Image();
                image.setPath(path);
                image.setUri(uri);
                list.add(image);
            }
        }


        imgAdapter = new ImageSelectAdapter(list, this);
        imgAdapter.setMax(MAX);
        binding.rvImg.setAdapter(imgAdapter);

        binding.rvImg.setLayoutManager(new GridLayoutManager(this, 4));
        getWindowManager().getDefaultDisplay().getWidth();

        imgAdapter.setOnCallBack(new ImageSelectAdapter.onCallBack() {
            @Override
            public void onCountChange(int count) {
                if (MAX == 1) {
                    Intent intent = new Intent();
                    String path = imgAdapter.getSelectList().toString();
                    int length = path.length();
                    imgAdapter.getSelectList().toString().substring(1, length);
                    intent.putExtra("IMAGE_FROM_ALBUM", imgAdapter.getSelectList().toString().substring(1, length - 1));
                    setResult(0, intent);
                    finish();
                } else {
                    binding.tvCount.setText("完成" + count);
                    imageSelect = imgAdapter.getSelectList();
                    modifyClick();
                }
            }

            @Override
            public void onShowBig(int index) {
                binding.clImgBig.setVisibility(View.VISIBLE);
//                imageModels = imgAdapter.getImageModels();
                imageSelect = imgAdapter.getSelectList();
                MyViewPagerAdapter adapter = new MyViewPagerAdapter();
                binding.vpImage.setAdapter(adapter);
                binding.vpImage.setCurrentItem(index, false);
                binding.tvIndex.setText((index + 1) + "/" + list.size());
//                imageShowIconAdapter.setList(imageSelect);
                binding.rvImgChecked.setAdapter(imageShowIconAdapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
                binding.rvImgChecked.setLayoutManager(layoutManager);
                modifyClick();
            }
        });

        binding.vpImage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("Vp----", "onPageScrolled" + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("Vp----", "onPageSelected" + position);
                binding.tvIndex.setText((position + 1) + "/" + list.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("Vp----", "onPageScrollStateChanged" + state);
            }
        });
    }


    public class MyViewPagerAdapter extends PagerAdapter {


        public MyViewPagerAdapter() {

        }

        @Override
        public int getCount() {
            return imgAdapter.getItemCount();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            final ImageModel item = imageModels.get(position);
            View view = View.inflate(MainActivity.this, R.layout.item_img_big, null);
            ImageView img = view.findViewById(R.id.img);
            final TextView tvIsSelect = view.findViewById(R.id.tvSelect);
            Glide.with(MainActivity.this).load(item.getPath()).into(img);
            container.addView(view);
            tvIsSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (item.isSelect()) {
                        item.setSelect(false);
                        tvIsSelect.setBackgroundResource(R.drawable.back_ring);
                        tvIsSelect.setText("");
                        imageSelect.remove(item.getPath());
                        notifyDataSetChanged();

                        imageShowIconAdapter.notifyDataSetChanged();
                    } else {


                        if (imgAdapter.getSelectList().size() == MAX) {
                            Toast.makeText(MainActivity.this, "最多选择" + MAX + "张图片", Toast.LENGTH_SHORT).show();
                        } else {
                            item.setSelect(true);
                            tvIsSelect.setBackgroundResource(R.drawable.back_img_green);
//                            imageSelect.add(item.getPath());
                            imageShowIconAdapter.notifyDataSetChanged();
                            tvIsSelect.setText(String.valueOf(imageSelect.indexOf(item.getPath()) + 1));

                            if (MAX == 1) {
                                Intent intent = new Intent();
                                intent.putExtra("IMAGE_FROM_ALBUM", item.getPath());
                                setResult(0, intent);
                                finish();
                            }

                        }
                    }
                    binding.tvCount.setText("完成" + imageSelect.size());
                    modifyClick();
                    imageModels.set(position, item);

                }
            });

            if (item.isSelect()) {
                tvIsSelect.setBackgroundResource(R.drawable.back_img_green);
                tvIsSelect.setText((imageSelect.indexOf(item.getPath()) + 1) + "");
            } else {
                tvIsSelect.setBackgroundResource(R.drawable.back_ring);
                tvIsSelect.setText("");
            }
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }


        private int mChildCount = 0;

        @Override
        public void notifyDataSetChanged() {
            mChildCount = getCount();
            super.notifyDataSetChanged();
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            if (mChildCount > 0) {
                mChildCount--;
                return POSITION_NONE;
            }
            return super.getItemPosition(object);
        }
    }
}

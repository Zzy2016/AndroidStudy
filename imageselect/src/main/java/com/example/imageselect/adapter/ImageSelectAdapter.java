package com.example.imageselect.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imageselect.Image;
import com.example.imageselect.ImageModel;
import com.example.imageselect.R;
import com.example.imageselect.databinding.ItemImgBinding;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageSelectAdapter extends RecyclerView.Adapter<ImageSelectAdapter.ViewHolder> {

    private List<Image> list;
    private Context context;
    //    private List<ImageModel> imageModels;
    private List<Image> selectList;

    private int max = 5;

//    public void setImageModels(List<ImageModel> imageModels) {
//        this.imageModels = imageModels;
//    }
//
//    public void setSelectList(List<Image> selectList) {
//        this.selectList = selectList;
//    }

    public ImageSelectAdapter(List<Image> list, Context context) {
        this.list = list;
        this.context = context;

        selectList = new ArrayList<>();

//        imageModels = new ArrayList<>();
//        for (Image item : list) {
//            ImageModel imageModel = new ImageModel();
//            imageModel.setSelect(false);
//            imageModel.setPath(item.getPath());
//            imageModels.add(imageModel);
//        }

    }

//    public List<ImageModel> getImageModels() {
//        return imageModels;
//    }

    public void setMax(int max) {
        this.max = max;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_img, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        ViewGroup.LayoutParams layoutParams = holder.binding.img.getLayoutParams();
        layoutParams.height =
                ((Activity) context).getWindowManager().getDefaultDisplay().getWidth() / 4;
        holder.binding.img.setLayoutParams(layoutParams);
//
        final Image image = list.get(position);

        Glide.with(context).load(image.getPath()).into(holder.binding.img);


        holder.binding.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (image.isSelect()) {
                    image.setSelect(false);
                    selectList.remove(image);
                    notifyDataSetChanged();
                } else {
                    if (selectList.size() == max) {
                        Toast.makeText(context, "最多选择" + max + "张图", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    selectList.add(image);
                    image.setSelect(true);
                    holder.binding.select.setText(String.valueOf(selectList.indexOf(image) + 1));
                }

                onCallBack.onCountChange(selectList.size());
                if (image.isSelect()) {
                    holder.binding.select.setBackgroundResource(R.drawable.back_img_green);
                    holder.binding.select.setText(String.valueOf(selectList.indexOf(image) + 1));
                } else {
                    holder.binding.select.setBackgroundResource(R.drawable.back_ring);
                }
            }
        });

        holder.binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onShowBig(position);
            }
        });

        if (image.isSelect()) {
            holder.binding.select.setBackgroundResource(R.drawable.back_img_green);
            holder.binding.select.setText(String.valueOf(selectList.indexOf(image) + 1));
        } else {
            holder.binding.select.setBackgroundResource(R.drawable.back_ring);
        }

    }


    public List<Image> getSelectList() {
        return selectList;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface onCallBack {
        void onCountChange(int count);

        void onShowBig(int index);
    }

    public onCallBack onCallBack;

    public void setOnCallBack(ImageSelectAdapter.onCallBack onCallBack) {
        this.onCallBack = onCallBack;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ItemImgBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemImgBinding.bind(itemView);
        }
    }
}

package com.example.imageselect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imageselect.R;

import java.util.List;

public class ImageShowIconAdapter extends RecyclerView.Adapter<ImageShowIconAdapter.ViewHolder> {

    private Context context;
    private List<String> list;

    public ImageShowIconAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public ImageShowIconAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_img_select, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallBack.onChange(list.get(position));
            }
        });
    }


    onCallBack onCallBack;

    public void setOnCallBack(ImageShowIconAdapter.onCallBack onCallBack) {
        this.onCallBack = onCallBack;
    }

    public interface onCallBack {
        void onChange(String path);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addImg(String path) {
        list.add(path);
        notifyDataSetChanged();
    }

    public void removeImg(String path) {
        list.remove(list.indexOf(path));
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}

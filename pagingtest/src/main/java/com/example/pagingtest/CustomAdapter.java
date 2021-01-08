package com.example.pagingtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends PagedListAdapter<ListBean.ItemsBean, CustomAdapter.ViewHolder> {


    private Context context;
    public CustomAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context=context;
    }


    private static DiffUtil.ItemCallback<ListBean.ItemsBean> DIFF_CALLBACK=new DiffUtil.ItemCallback<ListBean.ItemsBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull ListBean.ItemsBean oldItem, @NonNull ListBean.ItemsBean newItem) {
            return oldItem.getAccount_id()==newItem.getAccount_id();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull ListBean.ItemsBean oldItem, @NonNull ListBean.ItemsBean newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(getItem(position).getLink());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}

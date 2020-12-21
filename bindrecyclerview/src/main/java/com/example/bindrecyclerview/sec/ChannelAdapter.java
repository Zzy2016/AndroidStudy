package com.example.bindrecyclerview.sec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bindrecyclerview.R;

import java.util.Collections;
import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> {


    private Context mContext;
    private List<String> mSortedList;
    public boolean isEdit;//是否是编辑状态

    public ChannelAdapter(Context mContext, List<String> mSortedList) {
        this.mContext = mContext;
        this.mSortedList = mSortedList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.text_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(mSortedList.get(position));
    }

    @Override
    public int getItemCount() {
        return mSortedList.size();
    }



    void itemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mSortedList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mSortedList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}

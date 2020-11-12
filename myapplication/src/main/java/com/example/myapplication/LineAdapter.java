package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.LineItemBinding;

import java.util.ArrayList;
import java.util.List;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.ViewHolder> {


    private LineItemBinding binding;

    List<String> list = new ArrayList<>();

    public LineAdapter() {
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.line_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.binding.tvTime.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LineItemBinding binding;

        public ViewHolder(LineItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

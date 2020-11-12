package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.TableLayoutBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.TabItemBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {


    List<Test> list;

    String dateStart, dateEnd;


    int width;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public DateAdapter(Context context) {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Test test;
            if (i > 90) {
                test = new Test(4 + "", (i - 90) + "", 4 + "-" + (i - 90));
            } else if (i > 60) {
                test = new Test(3 + "", (i - 60) + "", 3 + "-" + (i - 60));
            } else if (i > 30) {
                test = new Test(2 + "", (i - 30) + "", 2 + "-" + (i - 30));
            } else {
                test = new Test(1 + "", i + "", 1 + "-" + i);
            }
            list.add(test);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getDisplay().getRealMetrics(displayMetrics);
        width = displayMetrics.widthPixels / 5;
    }

    public DateAdapter(List<Test> list, String dateStart, String dateEnd) {
        this.list = list;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 1);

        Log.e("日期",calendar.get(Calendar.MONTH)+"  ");

        Log.e("日期1",Calendar.getInstance().get(Calendar.MONTH)+"  ");


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TabItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.tab_item, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.binding.tv.getLayoutParams();
        layoutParams.width = width - 50;
        holder.binding.tv.setLayoutParams(layoutParams);
        holder.binding.setTest(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TabItemBinding binding;

        public ViewHolder(TabItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}

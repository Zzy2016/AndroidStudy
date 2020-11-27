package com.example.bindrecyclerview;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.MyViewHolder>{


    private Context context;
    private ArrayList<String> secondList;
    private int index = -1;//标记当前选择的选项
    public Handler handler=new Handler();

    public SecondAdapter(Context context, ArrayList<String> secondList) {
        this.context = context;
        this.secondList = secondList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_item_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_question_item.setText(secondList.get(position));
        holder.rb_question_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"您选择的选项是"+secondList.get(position),Toast.LENGTH_SHORT).show();
                index=position;
                notifyDataSetChanged();
            }
        });
        if(index==position){
            holder.rb_question_item.setChecked(true);
        } else {
            holder.rb_question_item.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return secondList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        RadioButton rb_question_item;
        TextView tv_question_item;
        public MyViewHolder(View itemView) {
            super(itemView);
            rb_question_item = itemView.findViewById(R.id.rb_question_item);
            tv_question_item = itemView.findViewById(R.id.tv_question_item);
        }
    }

}




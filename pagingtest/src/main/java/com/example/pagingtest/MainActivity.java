package com.example.pagingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

//implements implements Closeable https://api.stackexchange.com/2.2/users?page=1&pagesize=6&site=stackoverflow
public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    CustomAdapter customAdapter;
    MovieViewModel movieViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        customAdapter=new CustomAdapter(this);
        movieViewModel=new MovieViewModel();
        movieViewModel.pagedListLiveData.observe(this, new Observer<PagedList<ListBean.ItemsBean>>() {
            @Override
            public void onChanged(PagedList<ListBean.ItemsBean> itemsBeans) {
                customAdapter.submitList(itemsBeans);
            }
        });

        rv.setAdapter(customAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));



    }
}

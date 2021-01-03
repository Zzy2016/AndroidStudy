package com.example.pagingtest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class MovieViewModel extends ViewModel {
    public LiveData<PagedList<ListBean.ItemsBean>> pagedListLiveData;

    public MovieViewModel() {
        PagedList.Config config=new PagedList.Config.Builder().setEnablePlaceholders(true).setPageSize(10)
                .setPrefetchDistance(3).setInitialLoadSizeHint(10).build();
        pagedListLiveData=new LivePagedListBuilder<>(new DataSourceFactory(),config).build();
    }
}

package com.example.myfrgment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class LazyFragment extends Fragment {

    //该页面，是否准备完毕（onCreateView方法已调用完毕）
    private boolean isPrepared;
    //该Fragment是否已经执行过懒加载
//    private boolean isLazyLoader;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared=true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        lazyLoad();
    }

    private void lazyLoad(){
        if(getUserVisibleHint()&&isPrepared){
            onLazyLoad();
//            isLazyLoader=true;

        }
    }

    public abstract void onLazyLoad();
}

package com.example.androidstudy.bean.reponsebean.home;



import com.example.androidstudy.bean.reponsebean.HomeBanner;

import java.util.List;

/**
 * @author : devel
 * @date : 2020/2/25 13:36
 * @desc :
 */
public class BannerData {

    private List<HomeBanner> bannerData;

    public BannerData() {
    }

    public BannerData(List<HomeBanner> bannerData) {
        this.bannerData = bannerData;
    }

    public List<HomeBanner> getBannerData() {
        return bannerData;
    }

    public void setBannerData(List<HomeBanner> bannerData) {
        this.bannerData = bannerData;
    }
}

package com.fangsf.gankio.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fangsf on 2018/2/5.
 * Useful:
 */

public class DayDateBean {

    @SerializedName("Android") private List<DataBean> androidList;
    @SerializedName("休息视频") private List<DataBean> movieList;
    @SerializedName("iOS") private List<DataBean> iOSList;
    @SerializedName("福利") private List<DataBean> GilrList;
    @SerializedName("拓展资源") private List<DataBean> resList;
    @SerializedName("瞎推荐") private List<DataBean> recommendList;
    @SerializedName("App") private List<DataBean> appList;
    @SerializedName("前端") private List<DataBean> webList;

    public List<DataBean> getWebList() {
        return webList;
    }

    public void setWebList(List<DataBean> webList) {
        this.webList = webList;
    }

    public List<DataBean> getAndroidList() {
        return androidList;
    }

    public void setAndroidList(List<DataBean> androidList) {
        this.androidList = androidList;
    }

    public List<DataBean> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<DataBean> movieList) {
        this.movieList = movieList;
    }

    public List<DataBean> getiOSList() {
        return iOSList;
    }

    public void setiOSList(List<DataBean> iOSList) {
        this.iOSList = iOSList;
    }

    public List<DataBean> getGilrList() {
        return GilrList;
    }

    public void setGilrList(List<DataBean> gilrList) {
        GilrList = gilrList;
    }

    public List<DataBean> getResList() {
        return resList;
    }

    public void setResList(List<DataBean> resList) {
        this.resList = resList;
    }

    public List<DataBean> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<DataBean> recommendList) {
        this.recommendList = recommendList;
    }

    public List<DataBean> getAppList() {
        return appList;
    }

    public void setAppList(List<DataBean> appList) {
        this.appList = appList;
    }


}

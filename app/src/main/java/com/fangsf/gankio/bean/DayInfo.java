package com.fangsf.gankio.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fangsf on 2018/2/4.
 * Useful:
 */

public class DayInfo extends BaseBean<DayDateBean> {

    @SerializedName("category") private List<String> category ;
    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

}

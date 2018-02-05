package com.fangsf.gankio.common.rx;

import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.bean.DayInfo;
import com.fangsf.gankio.common.exception.GankExceptioin;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by fangsf on 2018/2/5.
 * Useful:  map 数据转换
 */

public class DayDataFunc implements Function<DayInfo, List<DataBean>> {
    @Override
    public List<DataBean> apply(DayInfo dayInfo) throws Exception {
        if (dayInfo.isError()) {
            throw new GankExceptioin();
        }


        List<String> category = new ArrayList<>();
        List<DataBean> dataBeans = new ArrayList<>();


        if (category.equals("福利")) dataBeans.addAll(dayInfo.getResults().getGilrList());
        if (category.contains("Android")) dataBeans.addAll(dayInfo.getResults().getAndroidList());
        if (category.contains("iOS")) dataBeans.addAll(dayInfo.getResults().getiOSList());
        if (category.contains("前端")) dataBeans.addAll(dayInfo.getResults().getWebList());
        if (category.contains("App")) dataBeans.addAll(dayInfo.getResults().getAppList());
        if (category.contains("拓展资源")) dataBeans.addAll(dayInfo.getResults().getResList());
        if (category.contains("瞎推荐")) dataBeans.addAll(dayInfo.getResults().getRecommendList());
        if (category.contains("休息视频")) dataBeans.addAll(dayInfo.getResults().getMovieList());


        return dataBeans;
    }
}

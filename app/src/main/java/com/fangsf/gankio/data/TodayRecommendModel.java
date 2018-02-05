package com.fangsf.gankio.data;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.DayInfo;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.TodayRecommendContract;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/2/4.
 * Useful:
 */

public class TodayRecommendModel implements TodayRecommendContract.TodayRecommendModel {

    private ApiServer mApiServer;

    public TodayRecommendModel(ApiServer apiServer) {
        mApiServer = apiServer;
    }

    @Override
    public Observable<DayInfo> getHistoriesRecommend(String date) {
        return mApiServer.getHistoriesRecommend(date);
    }

    @Override
    public Observable<BaseBean<ArrayList<String>>> getHistoriesDay() {
        return mApiServer.getHistoriesDay();
    }

    @Override
    public Observable<BaseBean<ArrayList<RandomBean>>> getRandomData(String type, String count) {
        return mApiServer.getRandomData(type, count);
    }
}

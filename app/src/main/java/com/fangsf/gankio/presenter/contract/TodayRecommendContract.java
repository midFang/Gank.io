package com.fangsf.gankio.presenter.contract;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.bean.DayInfo;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.presenter.BaseView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/2/4.
 * Useful:
 */

public class TodayRecommendContract {


    public interface TodayRecommendView extends BaseView {

        void showHistoryDay(BaseBean<ArrayList<String>> arrayListBaseBean);

        void showHistoryRecommend(List<DataBean> historyDayBean);

        void showImage(BaseBean<ArrayList<RandomBean>> arrayListBaseBean);
    }

    public interface TodayRecommendModel {

        Observable<DayInfo> getHistoriesRecommend(String date);

        Observable<BaseBean<ArrayList<String>>> getHistoriesDay();

        Observable<BaseBean<ArrayList<RandomBean>>> getRandomData(String type, String count);

    }


}

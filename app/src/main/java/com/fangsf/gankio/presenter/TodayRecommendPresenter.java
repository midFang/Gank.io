package com.fangsf.gankio.presenter;

import android.util.Log;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.bean.DayInfo;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.common.rx.DayDataFunc;
import com.fangsf.gankio.common.rx.RxSchedulers;
import com.fangsf.gankio.presenter.contract.TodayRecommendContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fangsf on 2018/2/4.
 * Useful:
 */

public class TodayRecommendPresenter extends BasePresneter<TodayRecommendContract.TodayRecommendModel, TodayRecommendContract.TodayRecommendView> {


    @Inject
    public TodayRecommendPresenter(TodayRecommendContract.TodayRecommendModel model, TodayRecommendContract.TodayRecommendView view) {
        super(model, view);
    }


    public void getHistoryDay() {

        mModel.getHistoriesDay().compose(RxSchedulers.<BaseBean<ArrayList<String>>>io_main())
                .subscribe(new Consumer<BaseBean<ArrayList<String>>>() {
                    @Override
                    public void accept(BaseBean<ArrayList<String>> arrayListBaseBean) throws Exception {
                        mView.showHistoryDay(arrayListBaseBean);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable.getMessage());
                        throwable.printStackTrace();
                    }
                });

    }


    public void getRandomImage(String type, String count) {

        mModel.getRandomData(type, count).compose(RxSchedulers.<BaseBean<ArrayList<RandomBean>>>io_main())
                .subscribe(new Consumer<BaseBean<ArrayList<RandomBean>>>() {
                    @Override
                    public void accept(BaseBean<ArrayList<RandomBean>> arrayListBaseBean) throws Exception {
                        mView.showImage(arrayListBaseBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        mView.showError(throwable.getMessage());
                    }
                });

    }

    public void getHistoriesRecommend(String date) {

        mModel.getHistoriesRecommend(date).compose(RxSchedulers.<DayInfo>io_main())
                .subscribe(new Consumer<DayInfo>() {
                    @Override
                    public void accept(DayInfo dayInfo) throws Exception {

                        //todo 该处 应该使用rxjava的操作符, 下方如何做处理?
                        List<String> category = dayInfo.getCategory();

                        List<DataBean> dataBeans = new ArrayList<>();

                        if (category.equals("福利")) dataBeans.addAll(dayInfo.getResults().getGilrList());
                        if (category.contains("Android")) dataBeans.addAll(dayInfo.getResults().getAndroidList());
                        if (category.contains("iOS")) dataBeans.addAll(dayInfo.getResults().getiOSList());
                        if (category.contains("前端")) dataBeans.addAll(dayInfo.getResults().getWebList());
                        if (category.contains("App")) dataBeans.addAll(dayInfo.getResults().getAppList());
                        if (category.contains("拓展资源")) dataBeans.addAll(dayInfo.getResults().getResList());
                        if (category.contains("瞎推荐")) dataBeans.addAll(dayInfo.getResults().getRecommendList());
                        if (category.contains("休息视频")) dataBeans.addAll(dayInfo.getResults().getMovieList());



                        mView.showHistoryRecommend(dataBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });


//        mModel.getHistoriesRecommend(date).compose(RxSchedulers.<DayInfo>io_main())
//                .map(new DayDataFunc())
//                .subscribe(new Consumer<List<DataBean>>() {
//                    @Override
//                    public void accept(List<DataBean> dataBeans) throws Exception {
//                        mView.showHistoryRecommend(dataBeans);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        mView.showError(throwable.getMessage());
//                        throwable.printStackTrace();
//                    }
//                });


        // todo  该处的 数据转化应该怎么做处理
//        mModel.getHistoriesRecommend(date).compose(RxSchedulers.<DayInfo>io_main())
//                .subscribe(new Consumer<DayInfo>() {
//                    @Override
//                    public void accept(DayInfo dayInfo) throws Exception {
//                        Log.i(TAG, "accept: ");
//
//                        Observable.just(dayInfo).compose(RxSchedulers.<DayInfo>io_main())
//                                .map(new DayDataFunc())
//                                .subscribe(new Consumer<List<DataBean>>() {
//                                    @Override
//                                    public void accept(List<DataBean> dataBeans) throws Exception {
//                                        mView.showHistoryRecommend(dataBeans);
//                                    }
//                                });
//
//                    }
//                });


    }


}

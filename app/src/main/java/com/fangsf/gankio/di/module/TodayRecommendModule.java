package com.fangsf.gankio.di.module;

import com.fangsf.gankio.data.TodayRecommendModel;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.TodayRecommendContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fangsf on 2018/2/4.
 * Useful:
 */

@Module
public class TodayRecommendModule {


    private TodayRecommendContract.TodayRecommendView mView;

    public TodayRecommendModule(TodayRecommendContract.TodayRecommendView view) {
        mView = view;
    }


    @Provides
    public TodayRecommendContract.TodayRecommendView provideView() {
        return mView;
    }

    @Provides
    public TodayRecommendContract.TodayRecommendModel provideModel(ApiServer apiServer) {
        return new TodayRecommendModel(apiServer);
    }


}

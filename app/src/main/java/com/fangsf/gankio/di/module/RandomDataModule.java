package com.fangsf.gankio.di.module;

import com.fangsf.gankio.data.RandomModel;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.RandomDataContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fangsf on 2018/2/3.
 * Useful: 提供 RandomPresenter 中的 M 和 V
 */

@Module
public class RandomDataModule {

    private RandomDataContract.IRandomDataView mView;

    public RandomDataModule(RandomDataContract.IRandomDataView view) {
        mView = view;
    }


    @Provides
    public RandomDataContract.IRandomDataView provideView () {
        return mView;
    }

    @Provides
    public RandomDataContract.IRandomDataModel provideModel(ApiServer apiServer) {
        return new RandomModel(apiServer);
    }

}

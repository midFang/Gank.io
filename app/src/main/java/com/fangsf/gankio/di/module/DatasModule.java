package com.fangsf.gankio.di.module;

import com.fangsf.gankio.data.DatasModel;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.DatasContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

@Module
public class DatasModule {


    private DatasContract.IDatasView mView;

    public DatasModule(DatasContract.IDatasView view) {
        mView = view;
    }

    @Provides
    public DatasContract.IDatasView provideView() {
        return mView;
    }

    @Provides
    public DatasContract.IDatasModel provideModel(ApiServer apiServer) {
        return new DatasModel(apiServer);
    }

}

package com.fangsf.gankio.di.module;

import com.fangsf.gankio.data.AndroidModel;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.di.component.AndroidComponent;
import com.fangsf.gankio.presenter.contract.AndroidContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

@Module
public class AndroidModule {


    private AndroidContract.IAndroidView mView;

    public AndroidModule(AndroidContract.IAndroidView view) {
        mView = view;
    }

    @Provides
    public AndroidContract.IAndroidView provideView() {
        return mView;
    }

    @Provides
    public AndroidContract.IAndroidModel provideModel(ApiServer apiServer) {
        return new AndroidModel(apiServer);
    }

}

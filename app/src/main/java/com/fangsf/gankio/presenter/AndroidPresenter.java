package com.fangsf.gankio.presenter;

import com.fangsf.gankio.presenter.contract.AndroidContract;

import javax.inject.Inject;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class AndroidPresenter extends BasePresneter<AndroidContract.IAndroidModel, AndroidContract.IAndroidView> {

    @Inject
    public AndroidPresenter(AndroidContract.IAndroidModel model, AndroidContract.IAndroidView view) {
        super(model, view);
    }


    public void getAndroidData() {
    }



}

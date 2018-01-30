package com.fangsf.gankio.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by fangsf on 2018/1/29.
 * Useful:
 */

public class BasePresneter<M, V extends BaseView> {

    protected M mModel;
    protected V mView;

    protected Context mContext;

    public BasePresneter(M model, V view) {
        mModel = model;
        mView = view;

        initContext();
    }

    private void initContext() {
        if (mView instanceof Fragment) {
            mContext = ((Fragment) mView).getActivity();
        } else {
            mContext = (Activity) mView;
        }
    }


}

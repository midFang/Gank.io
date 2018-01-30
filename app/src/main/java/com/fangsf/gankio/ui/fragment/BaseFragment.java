package com.fangsf.gankio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fangsf.gankio.presenter.BasePresneter;

import javax.inject.Inject;

/**
 * @author fangsf
 * @date 2017/11/23.
 */

public abstract class BaseFragment<T extends BasePresneter> extends Fragment {

    @Inject
    T mPresenter;

    private final String TAG = this.getClass().getSimpleName();

    private View mRootView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(bindLayout(), container, false);
       init();
        return mRootView;

    }

    protected abstract void init();

    protected abstract int bindLayout();
}

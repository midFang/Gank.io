package com.fangsf.gankio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fangsf.gankio.AppApplication;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.presenter.BasePresneter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author fangsf
 * @date 2017/11/23.
 */

public abstract class BaseFragment<T extends BasePresneter> extends Fragment {

    @Inject
   public T mPresenter;

    private Unbinder mUnbinder;
    protected AppApplication mAppApplication;

    private final String TAG = this.getClass().getSimpleName();

    private View mRootView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(bindLayout(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);

        return mRootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.mAppApplication = (AppApplication) getActivity().getApplication();

        setupActivityComponent(mAppApplication.getAppComponent());
        init();
    }

    protected abstract int bindLayout();

    protected abstract void setupActivityComponent(AppComponent appComponent);

    protected abstract void init();

    public void toast(String mes) {
        Toast.makeText(getContext(), ""+mes, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }
}

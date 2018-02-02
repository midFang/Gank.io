package com.fangsf.gankio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.fangsf.gankio.AppApplication;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.presenter.BasePresneter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author fangsf
 * @date 2017/11/23
 */

public abstract class BaseActivity<T extends BasePresneter> extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    private Unbinder mUnbinder;

    @Inject
    T mPresenter;

    public AppApplication mAppApplication;

    protected View mContextView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContextView = LayoutInflater.from(this)
                .inflate(bindLayout(), null);
        setContentView(mContextView);
        mUnbinder =   ButterKnife.bind(this);

        mAppApplication = (AppApplication) getApplication();

        setupActivityComponent(mAppApplication.getAppComponent());


        init();
    }

    protected abstract int bindLayout();

    protected abstract void setupActivityComponent(AppComponent appComponent);

    protected abstract void init();

    protected void toast(String mes) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
    }

    public void jumpAct(Class clz) {
        startActivity(new Intent(this, clz));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }
}

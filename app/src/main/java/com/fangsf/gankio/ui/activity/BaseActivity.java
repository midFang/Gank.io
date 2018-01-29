package com.fangsf.gankio.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author fangsf
 * @date 2017/11/23
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected final String TAG = this.getClass().getSimpleName();
    
    private final boolean isDebug = true;

    private Unbinder mUnbinder;

    protected Context mContext = this;
    protected View mContextView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $Log(TAG + "--->onCreate()");
        
        mContextView = LayoutInflater.from(this)
                .inflate(bindLayout(), null);
        setContentView(mContextView);
        mUnbinder =   ButterKnife.bind(this);

        init();
        initListener();
    }

    protected abstract void init();

    protected abstract int bindLayout();


    protected abstract void initListener();

    protected void $Log(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    @Override
    public void onClick(View view) {
        
    }

    protected void toast(String mes) {
        Toast.makeText(mContext, mes, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        $Log(TAG + "--->onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        $Log(TAG + "--->onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        $Log(TAG + "--->onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        $Log(TAG + "--->onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        $Log(TAG + "--->onDestroy()");
        mUnbinder.unbind();
    }
}

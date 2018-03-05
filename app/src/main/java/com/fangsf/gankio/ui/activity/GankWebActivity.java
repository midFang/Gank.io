package com.fangsf.gankio.ui.activity;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;

import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.common.Constant;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.ui.widget.MyWebViewClient;
import com.fangsf.gankio.ui.widget.ProgressWebView;
import com.fangsf.minddemo.R;

import butterknife.BindView;

public class GankWebActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.webView)
    ProgressWebView mWebView;
    private DataBean mDataBean;

    @Override
    protected int bindLayout() {
        return R.layout.activity_gank_web;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void init() {

        initData();

        initToolbar(mToolbar);


    }

    private void initData() {


        mDataBean = (DataBean) getIntent().getSerializableExtra(Constant.WEB_DATA_BEAN);


        WebSettings settings = mWebView.getSettings();

        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {

                        // 回退
                        mWebView.goBack();

                    }
                    // 已处理
                    return true;
                }

                return false;
            }
        });

        mToolbar.setTitle(mDataBean.getDesc());
        mWebView.loadUrl(mDataBean.getUrl());

    }

    @Override
    protected void onStop() {
        super.onStop();
        mWebView.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
    }


}

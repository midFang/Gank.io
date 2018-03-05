package com.fangsf.gankio.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.ui.fragment.SettingFragment;
import com.fangsf.minddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.flSetting)
    FrameLayout mFlSetting;

    @Override
    protected int bindLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
    }

    @Override
    protected void init() {

        initToolbar(mToolbar);
        mToolbar.setTitle("设置与帮助");

        initFragment();

    }

    private void initFragment() {
        getFragmentManager().beginTransaction().replace(R.id.flSetting, new SettingFragment()).commit();
    }

}

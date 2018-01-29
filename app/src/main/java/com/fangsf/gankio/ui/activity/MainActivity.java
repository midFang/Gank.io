package com.fangsf.gankio.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.fangsf.gankio.ui.adapter.HomePageAdapter;
import com.fangsf.minddemo.R;

import butterknife.BindView;

/**
 * @author fangsf
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.vpHome)
    ViewPager mVpHome;
    @BindView(R.id.navigationview)
    NavigationView mNavigationview;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void init() {

        initToolbar();
        initTab();
    }

    private void initToolbar() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        toggle.syncState();
    }

    private void initTab() {
        mVpHome.setAdapter(new HomePageAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mVpHome);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {

    }


}

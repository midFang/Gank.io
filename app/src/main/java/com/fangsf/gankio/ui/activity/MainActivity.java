package com.fangsf.gankio.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.common.utils.AppManager;
import com.fangsf.gankio.common.utils.DensityUtil;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.di.component.DaggerRandomDataComponent;
import com.fangsf.gankio.di.module.RandomDataModule;
import com.fangsf.gankio.presenter.RandomPresenter;
import com.fangsf.gankio.presenter.contract.RandomDataContract;
import com.fangsf.gankio.ui.adapter.HomePageAdapter;
import com.fangsf.minddemo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;

/**
 * @author fangsf
 */
public class MainActivity extends BaseActivity<RandomPresenter> implements RandomDataContract.IRandomDataView {

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
    private ImageView mIvGirl;

    private long mExitTime = 0;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        mPresenter.getRandomData("福利", "1");

        initToolbar();
        initTab();
        initNavigationView();
    }


    private void initNavigationView() {
        View headerView = mNavigationview.getHeaderView(0);

        mIvGirl = headerView.findViewById(R.id.ivGirl);
        TextView tvDate = headerView.findViewById(R.id.tvDate);

        String time = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        tvDate.setText(time);

        mNavigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.setting:
                        jumpAct(SettingActivity.class);
                        break;

                    case R.id.collect:
                        toast("我的收藏");
                        break;

                    case R.id.recommend:
                        jumpAct(TodayRecommendActivity.class);
                        break;

                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void initToolbar() {
        mToolbar.inflateMenu(R.menu.toolbar_menu);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        toggle.syncState();

        mToolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.actionSearch) {
                toast("搜索");
            }

            return true;
        });
    }

    private void initTab() {
        mVpHome.setAdapter(new HomePageAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mVpHome);
    }


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerRandomDataComponent.builder().appComponent(appComponent)
                .randomDataModule(new RandomDataModule(this))
                .build().inject(this);

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String mes) {
        toast(mes);
    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showData(ArrayList<RandomBean> randomBean) {
        Glide.with(this).load(randomBean.get(0).getUrl() + "?imageView2/0/w/" + DensityUtil.getScreenW(this)).error(R.mipmap.test).into(mIvGirl);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();// 更新mExitTime
            } else {
                AppManager.getAppManager().exitApp();
               // System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

}

package com.fangsf.gankio;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.fangsf.minddemo.R;
import com.fangsf.gankio.ui.adapter.IndexAdapter;
import com.fangsf.gankio.ui.activity.BaseActivity;
import com.fangsf.gankio.bean.TabBean;
import com.fangsf.gankio.ui.fragment.ContentFragment;
import com.fangsf.gankio.ui.fragment.HomeFragment;
import com.fangsf.gankio.ui.fragment.MzFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author fangsf
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.vpHome)
    ViewPager mVpHome;
    @BindView(R.id.tabHome)
    CommonTabLayout mTabHome;

    private ArrayList<Fragment> mFragments;
    private ArrayList<CustomTabEntity> mTabEntities;

    private static final int[] SELECTED_ICONS = new int[]{R.drawable.ic_index, R.drawable.ic_content, R.drawable.ic_mine};
    private static final int[] UN_SELECTED_ICONS = new int[]{R.drawable.ic_index_unselect, R.drawable.ic_content_unselect, R.drawable.ic_mine_unselect};
    private static final String[] TITLES = new String[]{"首页", "内容", "我的"};


    @Override
    protected void init() {

        initAdapter();

        initTabLayout();


    }

    private void initTabLayout() {
        mTabEntities = new ArrayList<>();

        for (int i = 0; i < TITLES.length; i++) {
            mTabEntities.add(new TabBean(SELECTED_ICONS[i], UN_SELECTED_ICONS[i], TITLES[i]));
        }
        
        mTabHome.setTabData(mTabEntities);
        mTabHome.setCurrentTab(0);
    }

    private void initAdapter() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new ContentFragment());
        mFragments.add(new MzFragment());

        mVpHome.setAdapter(new IndexAdapter(getSupportFragmentManager(), mFragments));
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void initListener() {
        mTabHome.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVpHome.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        
        mVpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {
                mTabHome.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}

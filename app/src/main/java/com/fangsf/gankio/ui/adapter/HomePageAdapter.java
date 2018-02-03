package com.fangsf.gankio.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fangsf.gankio.bean.FragmentInfo;
import com.fangsf.gankio.ui.fragment.hometab.AllFragment;
import com.fangsf.gankio.ui.fragment.hometab.BlindRecommendFragment;
import com.fangsf.gankio.ui.fragment.hometab.IOSFragment;
import com.fangsf.gankio.ui.fragment.hometab.AndroidFragment;
import com.fangsf.gankio.ui.fragment.hometab.MzFragment;
import com.fangsf.gankio.ui.fragment.hometab.TodayRecommendFragment;
import com.fangsf.gankio.ui.fragment.hometab.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangsf on 2018/1/29.
 * Useful:
 */

public class HomePageAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> mFragmentList = new ArrayList<>();

    public HomePageAdapter(FragmentManager fm) {
        super(fm);

        initFragment( );
    }

    private void initFragment() {
        mFragmentList.add(new FragmentInfo("今日推荐", TodayRecommendFragment.class));
        mFragmentList.add(new FragmentInfo("All", AllFragment.class));
        mFragmentList.add(new FragmentInfo("Android", AndroidFragment.class));
        mFragmentList.add(new FragmentInfo("福利", MzFragment.class));
        mFragmentList.add(new FragmentInfo("休息视频", VideoFragment.class));
        mFragmentList.add(new FragmentInfo("iOS", IOSFragment.class));
        mFragmentList.add(new FragmentInfo("瞎推荐", BlindRecommendFragment.class));
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mFragmentList.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return mFragmentList.get(position).getTitle();
    }
}

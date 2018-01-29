package com.fangsf.gankio.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fangsf.gankio.bean.FragmentInfo;
import com.fangsf.gankio.ui.fragment.ContentFragment;
import com.fangsf.gankio.ui.fragment.HomeFragment;
import com.fangsf.gankio.ui.fragment.MzFragment;

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
        mFragmentList.add(new FragmentInfo("Android", HomeFragment.class));
        mFragmentList.add(new FragmentInfo("福利", MzFragment.class));
        mFragmentList.add(new FragmentInfo("ios", ContentFragment.class));
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

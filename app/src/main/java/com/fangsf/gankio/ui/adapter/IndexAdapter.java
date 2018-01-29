package com.fangsf.gankio.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author fangsf
 * @date 2018/1/5.
 * @useful:
 */

public class IndexAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    
    public IndexAdapter(FragmentManager fm,List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
    
    @Override
    public int getCount() {
        return mFragments.size();
    }


}

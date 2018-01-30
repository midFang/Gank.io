package com.fangsf.gankio.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fangsf.minddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author fangsf
 * @date 2018/1/5.
 * @useful:
 */

public class AndroidFragment extends BaseFragment {


    @BindView(R.id.rcView)
    RecyclerView mRcView;

    @Override
    protected void init() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.template_recylerview;
    }



}

package com.fangsf.gankio.ui.fragment.hometab;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.di.component.DaggerRandomDataComponent;
import com.fangsf.gankio.di.module.RandomDataModule;
import com.fangsf.gankio.presenter.RandomPresenter;
import com.fangsf.gankio.presenter.contract.RandomDataContract;
import com.fangsf.gankio.ui.adapter.RandomDataAdapter;
import com.fangsf.gankio.ui.fragment.BaseFragment;
import com.fangsf.gankio.ui.widget.SpaceItemDecoration;
import com.fangsf.minddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author fangsf
 * @date 2018/1/5.
 * @useful:
 */

public class MzFragment extends BaseFragment<RandomPresenter> implements RandomDataContract.IRandomDataView {

    @BindView(R.id.rcView)
    RecyclerView mRcView;
    @BindView(R.id.swRefresh)
    SwipeRefreshLayout mSwRefresh;


    private int count = 20;

    private RandomDataAdapter mAdapter;

    @Override
    protected void init() {
        mPresenter.getRandomData("福利", String.valueOf(count));

        initAdapter();

        initRefresh();

    }


    private void initRefresh() {

        mSwRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.getData().clear();
                mPresenter.getRandomData("福利", String.valueOf(count));
            }
        });

    }

    private void initAdapter() {

        mAdapter = new RandomDataAdapter(R.layout.item_imageview);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRcView.addItemDecoration(new SpaceItemDecoration(20));
        mRcView.setLayoutManager(layoutManager);
        mRcView.setAdapter(mAdapter);

    }

    @Override
    protected int bindLayout() {
        return R.layout.template_recylerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerRandomDataComponent.builder().appComponent(appComponent)
                .randomDataModule(new RandomDataModule(this))
                .build().inject(this);
    }

    @Override
    public void showLoading() {
        mSwRefresh.setRefreshing(true);
    }

    @Override
    public void showError(String mes) {
        mSwRefresh.setRefreshing(false);
        toast(mes);
    }

    @Override
    public void dismissLoading() {
        mSwRefresh.setRefreshing(false);
    }

    @Override
    public void showData(ArrayList<RandomBean> randomBean) {
        mAdapter.addData(randomBean);
    }
}

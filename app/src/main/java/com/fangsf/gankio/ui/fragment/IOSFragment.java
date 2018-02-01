package com.fangsf.gankio.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.di.component.DaggerDatasComponent;
import com.fangsf.gankio.di.module.DatasModule;
import com.fangsf.gankio.presenter.DataPresenter;
import com.fangsf.gankio.presenter.contract.DatasContract;
import com.fangsf.gankio.ui.adapter.DatasAdapter;
import com.fangsf.minddemo.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author fangsf
 * @date 2018/1/5.
 * @useful:
 */

public class IOSFragment extends BaseFragment<DataPresenter> implements DatasContract.IDatasView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rcView)
    RecyclerView mRcView;
    @BindView(R.id.swRefresh)
    SwipeRefreshLayout mRefreshLayout;

    private DatasAdapter mAdapter;

    private int count = 10;

    @Override
    protected void init() {

        mPresenter.requestData("iOS",count);
        initRecylserView();

        initRefresh();
    }

    private void initRefresh() {
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.getData().clear();
                mPresenter.requestData("iOS",count);
            }
        });
    }

    private void initRecylserView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRcView.setLayoutManager(manager);
        mAdapter = new DatasAdapter(R.layout.item_cardview);
        mRcView.setAdapter(mAdapter);
        mAdapter.setEnableLoadMore(true);
        mAdapter.openLoadAnimation();
        mAdapter.setOnLoadMoreListener(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.template_recylerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerDatasComponent.builder().appComponent(appComponent)
                .datasModule(new DatasModule(this))
                .build().inject(this);
    }


    @Override
    public void showLoading() {
        mRefreshLayout.setRefreshing(true);
    }

    @Override
    public void showError(String mes) {
        toast(mes);
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void dismissLoading() {
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showData(ArrayList<DataBean> dataBeans) {
        mAdapter.addData(dataBeans);
    }

    @Override
    public void loadMore(ArrayList<DataBean> dataBeans) {
        mAdapter.setNewData(dataBeans);
    }

    @Override
    public void onLoadMoreRequested() {
        count += 10;
        mPresenter.requestData("iOS",count);
    }
}

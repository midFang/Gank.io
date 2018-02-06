package com.fangsf.gankio.ui.fragment.hometab;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.common.Constant;
import com.fangsf.gankio.presenter.DataPresenter;
import com.fangsf.gankio.presenter.contract.DatasContract;
import com.fangsf.gankio.ui.activity.GankWebActivity;
import com.fangsf.gankio.ui.adapter.DatasAdapter;
import com.fangsf.gankio.ui.fragment.BaseFragment;
import com.fangsf.minddemo.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by fangsf on 2018/2/1.
 * Useful:
 */

public abstract class DatasFragment extends BaseFragment<DataPresenter> implements DatasContract.IDatasView, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.rcView)
    RecyclerView mRcView;
    @BindView(R.id.swRefresh)
    SwipeRefreshLayout mRefreshLayout;

    private DatasAdapter mAdapter;

    private int count = loadCount();

    protected abstract int loadCount();

    @Override
    protected int bindLayout() {
        return R.layout.template_recylerview;
    }

    @Override
    protected void init() {
        mPresenter.requestData(type(), count);
        initRecylerView();

        initRefresh();
    }

    protected abstract String type();

    private void initRefresh() {
        mRefreshLayout.setOnRefreshListener(() -> {
            count = 10;
            mPresenter.requestData(type(), count);
        });
    }

    private void initRecylerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRcView.setLayoutManager(manager);
        mAdapter = new DatasAdapter(R.layout.item_cardview);
        mRcView.setAdapter(mAdapter);
        mAdapter.setEnableLoadMore(true);
//        mAdapter.openLoadAnimation();
        mAdapter.setOnLoadMoreListener(this);


        mRcView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                DataBean dataBean = mAdapter.getData().get(position);


                if (!dataBean.getType().equals("福利")) {
                    Intent intent = new Intent(getContext(), GankWebActivity.class);
                    intent.putExtra(Constant.WEB_DATA_BEAN, dataBean);
                    startActivity(intent);
                }

            }
        });


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
        mAdapter.getData().clear();
        mAdapter.addData(dataBeans);

    }

    @Override
    public void loadMore(ArrayList<DataBean> dataBeans) {
        mAdapter.setNewData(dataBeans);
    }

    @Override
    public void onLoadMoreRequested() {
        count += 5;
        mPresenter.requestData(type(), count);
    }
}

package com.fangsf.gankio.ui.fragment.hometab;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fangsf.gankio.bean.VideoBean;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.di.component.DaggerVideoComponent;
import com.fangsf.gankio.di.module.VideoModule;
import com.fangsf.gankio.presenter.VideoPresenter;
import com.fangsf.gankio.presenter.contract.VideoContract;
import com.fangsf.gankio.ui.adapter.VideoAdapter;
import com.fangsf.gankio.ui.fragment.BaseFragment;
import com.fangsf.minddemo.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by fangsf on 2018/2/1.
 * Useful:
 */

public class VideoFragment extends BaseFragment<VideoPresenter> implements VideoContract.IVideoView {

    @BindView(R.id.rcView)
    RecyclerView mRcView;
    @BindView(R.id.swRefresh)
    SwipeRefreshLayout mSwRefresh;

    private VideoAdapter mAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.template_recylerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerVideoComponent.builder().appComponent(appComponent)
                .videoModule(new VideoModule(this))
                .build().inject(this);
    }

    @Override
    protected void init() {
        mPresenter.getVideoData();

        initAdapter();

        initRefresh();
    }

    private void initRefresh() {
        mSwRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mAdapter.getData().clear();

                mPresenter.getVideoData();
            }
        });
    }

    private void initAdapter() {
        mAdapter = new VideoAdapter(R.layout.item_video);
        mRcView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRcView.setAdapter(mAdapter);
    }

    @Override
    public void showLoading() {
        mSwRefresh.setRefreshing(true);
    }

    @Override
    public void showError(String mes) {

    }

    @Override
    public void dismissLoading() {
        mSwRefresh.setRefreshing(false);
    }

    @Override
    public void showData(VideoBean videoBean) {
        mAdapter.addData(videoBean.getTrailers());
    }

    @Override
    public void onPause() {
        super.onPause();

        if (mAdapter.mVideoPlayer != null) {
            mAdapter.mVideoPlayer.clearCurrentCache();
            mAdapter.mVideoPlayer.release();
            GSYVideoManager.onPause();
        }
    }

}

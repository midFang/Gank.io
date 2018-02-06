package com.fangsf.gankio.ui.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.common.Constant;
import com.fangsf.gankio.common.utils.DensityUtil;
import com.fangsf.gankio.common.utils.SystemBarHelper;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.di.component.DaggerTodayRecommendComponent;
import com.fangsf.gankio.di.module.TodayRecommendModule;
import com.fangsf.gankio.presenter.TodayRecommendPresenter;
import com.fangsf.gankio.presenter.contract.TodayRecommendContract;
import com.fangsf.gankio.ui.adapter.TodayRecommendAdapter;
import com.fangsf.minddemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TodayRecommendActivity extends BaseActivity<TodayRecommendPresenter> implements TodayRecommendContract.TodayRecommendView {

    @BindView(R.id.imageViewToday)
    ImageView mImageViewToday;
    @BindView(R.id.toolbarDay)
    Toolbar mToolbarDay;
    @BindView(R.id.collapsingDay)
    CollapsingToolbarLayout mCollapsingDay;
    @BindView(R.id.recyclerViewToday)
    RecyclerView mRecyclerViewToday;

    private TodayRecommendAdapter mAdapter;

    private String type = "福利";
    private int count = 1;
    private String date = "2018/01/29";

    @Override
    protected int bindLayout() {
        return R.layout.activity_today_recommend;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerTodayRecommendComponent.builder().appComponent(appComponent)
                .todayRecommendModule(new TodayRecommendModule(this))
                .build().inject(this);

    }

    @Override
    protected void init() {
        initToolbar();



        mPresenter.getRandomImage(type, String.valueOf(count));
        mPresenter.getHistoryDay();
    }

    private void initAdapter(List<DataBean> historyDayBean) {

        mAdapter = new TodayRecommendAdapter(R.layout.item_recommend, historyDayBean);
        mRecyclerViewToday.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewToday.setAdapter(mAdapter);

        mRecyclerViewToday.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                DataBean dataBean = mAdapter.getData().get(position);


                if (!dataBean.getType().equals("福利")) {
                    Intent intent = new Intent(TodayRecommendActivity.this, GankWebActivity.class);
                    intent.putExtra(Constant.WEB_DATA_BEAN, dataBean);
                    startActivity(intent);
                }

            }
        });

    }

    private void initToolbar() {
        SystemBarHelper.immersiveStatusBar(this, 0);
        SystemBarHelper.setHeightAndPadding(this, mToolbarDay);

        setSupportActionBar(mToolbarDay);
        mToolbarDay.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);

        mToolbarDay.setNavigationOnClickListener(v -> finish());
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
    public void showHistoryDay(BaseBean<ArrayList<String>> arrayListBaseBean) {
        ArrayList<String> dayList = arrayListBaseBean.getResults();

        if (dayList != null) {
            String date = dayList.get(0).replace("-", "/");
            mPresenter.getHistoriesRecommend(date);

        }

    }

    @Override
    public void showHistoryRecommend(List<DataBean> historyDayBean) {

        initAdapter(historyDayBean);
//        mAdapter.addData(historyDayBean);

    }

    @Override
    public void showImage(BaseBean<ArrayList<RandomBean>> arrayListBaseBean) {

        Glide.with(this).load(arrayListBaseBean.getResults().get(0).getUrl()
                + "?imageView2/0/w/" + DensityUtil.getScreenW(this)).error(R.mipmap.test).into(mImageViewToday);

    }
}

package com.fangsf.gankio.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fangsf.gankio.bean.ResultBean;
import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.di.component.DaggerAndroidComponent;
import com.fangsf.gankio.di.module.AndroidModule;
import com.fangsf.gankio.presenter.AndroidPresenter;
import com.fangsf.gankio.presenter.contract.AndroidContract;
import com.fangsf.gankio.ui.adapter.AndroidAdapter;
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

public class AndroidFragment extends BaseFragment<AndroidPresenter> implements AndroidContract.IAndroidView{


    @BindView(R.id.rcView)
    RecyclerView mRcView;

    private AndroidAdapter mAndroidAdapter;

    @Override
    protected void init() {
        mPresenter.getAndroidData();
        initRecylserView();
    }

    private void initRecylserView() {
        mRcView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAndroidAdapter = new AndroidAdapter(R.layout.item_cardview);
        mRcView.setAdapter(mAndroidAdapter);
    }

    @Override
    protected int bindLayout() {
        return R.layout.template_recylerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerAndroidComponent.builder().appComponent(appComponent)
                .androidModule(new AndroidModule(this))
                .build().inject(this);
    }



    @Override
    public void showError(String mes) {
        toast(mes);
    }

    @Override
    public void showData(ArrayList<ResultBean> resultBeans) {
        mAndroidAdapter.addData(resultBeans);
    }
}

package com.fangsf.gankio.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.minddemo.R;

/**
 * Created by fangsf on 2018/2/4.
 * Useful:
 */

public class TodayRecommendAdapter extends BaseQuickAdapter<DataBean, BaseViewHolder> {


    public TodayRecommendAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean item) {

        if (item != null) {

           helper.setText(R.id.tvTitle, item.getDesc());

        }

    }


}

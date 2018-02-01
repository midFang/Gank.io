package com.fangsf.gankio.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.minddemo.R;

/**
 * Created by fangsf on 2018/1/31.
 * Useful:
 */

public class DatasAdapter extends BaseQuickAdapter<DataBean, BaseViewHolder> {

    public DatasAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean dataBean) {


        if (dataBean != null) {

            helper.setText(R.id.tvTitle, dataBean.getDesc());
            helper.setText(R.id.tvAuthor, dataBean.getWho());

        }


    }


}

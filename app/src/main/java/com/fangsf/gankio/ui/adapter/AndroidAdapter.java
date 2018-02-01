package com.fangsf.gankio.ui.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fangsf.gankio.bean.ResultBean;
import com.fangsf.minddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangsf on 2018/1/31.
 * Useful:
 */

public class AndroidAdapter extends BaseQuickAdapter<ResultBean, BaseViewHolder> {

    public AndroidAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ResultBean resultBean) {


        if (resultBean != null) {

            helper.setText(R.id.tvTitle, resultBean.getDesc());
            helper.setText(R.id.tvAuthor, resultBean.getWho());

        }


    }


}

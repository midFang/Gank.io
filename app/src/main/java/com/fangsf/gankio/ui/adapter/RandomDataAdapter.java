package com.fangsf.gankio.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.common.utils.DensityUtil;
import com.fangsf.gankio.common.utils.RelateTimeUtil;
import com.fangsf.gankio.ui.fragment.hometab.MzFragment;
import com.fangsf.minddemo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fangsf on 2018/1/31.
 * Useful:
 */

public class RandomDataAdapter extends BaseQuickAdapter<RandomBean, BaseViewHolder> {

    public RandomDataAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, RandomBean dataBean) {

        if (dataBean != null) {

            Glide.with(mContext).load(dataBean.getUrl() + "?imageView2/0/w/" + DensityUtil.getScreenW(mContext)).into((ImageView) helper.getView(R.id.ivGirl));


        }
    }

}

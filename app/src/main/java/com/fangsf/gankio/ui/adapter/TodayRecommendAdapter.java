package com.fangsf.gankio.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.common.utils.DensityUtil;
import com.fangsf.minddemo.R;

import java.util.List;

/**
 * Created by fangsf on 2018/2/4.
 * Useful:
 */

public class TodayRecommendAdapter extends BaseQuickAdapter<DataBean, BaseViewHolder> {


    public TodayRecommendAdapter(int layoutResId, List<DataBean> data) {
        super(layoutResId, data);

        this.mData = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean items) {

        DataBean item = mData.get(helper.getLayoutPosition());

        TextView categoryDay = helper.getView(R.id.categoryDay);


        if (item != null) {

            if (helper.getLayoutPosition() == 0) {

                categoryDay.setVisibility(View.VISIBLE);
            } else {

                boolean isSame = mData.get(helper.getLayoutPosition() - 1).getType().equals(mData.get(helper.getLayoutPosition()).getType());
                if (isSame) {
                    categoryDay.setVisibility(View.GONE);
                } else {
                    categoryDay.setVisibility(View.VISIBLE);
                }

            }

            categoryDay.setText(item.getType());
            helper.setText(R.id.tvTitle, item.getDesc());

            ImageView imageView = helper.getView(R.id.ivImg);

            if (item.getImages() != null) {
                imageView.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(item.getImages().get(0) + "?imageView2/0/w/"
                        + DensityUtil.getScreenW(mContext)).into(imageView);
            } else {
                imageView.setVisibility(View.GONE);
            }

            if (item.getWho() != null) {
                helper.setText(R.id.tvAuthor, item.getWho());
            }
        }

    }


}

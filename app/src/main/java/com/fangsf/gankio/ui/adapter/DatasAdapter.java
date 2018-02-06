package com.fangsf.gankio.ui.adapter;

import android.support.v7.view.menu.MenuAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.common.utils.DensityUtil;
import com.fangsf.gankio.common.utils.RelateTimeUtil;
import com.fangsf.minddemo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        ImageView imageView = helper.getView(R.id.ivImg);

        if (dataBean != null) {

            if (dataBean.getType().equals("福利")) {

                // 只有在福利的type下 才有图片
                String url = dataBean.getUrl();

                if (url != null) {
                    imageView.setVisibility(View.VISIBLE);
                    Glide.with(mContext).load(url +"?imageView2/0/w/"+ DensityUtil.getScreenW(mContext)).into(imageView);
                } else {
                    imageView.setVisibility(View.GONE);
                }


            } else {
                imageView.setVisibility(View.GONE);

                helper.setText(R.id.tvTitle, dataBean.getDesc());
                helper.setText(R.id.tvAuthor, dataBean.getWho());

                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dataBean.getPublishedAt());
                    //todo 时间  的 days ago  是怎么转换的
                    CharSequence time = RelateTimeUtil.getRelativeTime(mContext, date.getTime());
                    helper.setText(R.id.tvDays, time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }


        }


    }


}

package com.fangsf.gankio.ui.adapter;

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


        if (dataBean != null) {

            if (dataBean.getType().equals("福利")) {

                // todo 判断当前加载的 的页面是 allFragment tomorrow todo
                Glide.with(mContext).load(dataBean.getUrl().toString()+"?imageView2/0/w/"+ DensityUtil.getScreenW(mContext)).into((ImageView) helper.getView(R.id.ivImg));

            } else {
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

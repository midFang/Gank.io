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

public class AndroidAdapter extends BaseQuickAdapter<ArrayList<ResultBean>, BaseViewHolder> {

    public AndroidAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArrayList<ResultBean> item) {

        if (item != null) {
            TextView tvTitle = helper.getView(R.id.tvTitle);
            tvTitle.setText(item.get(helper.getAdapterPosition()).getType());


            ImageView ivImg = helper.getView(R.id.ivImg);
//            List<String> images = item.get(helper.getAdapterPosition()).getImages();
//            if (images != null) {
//
//                Glide.with(mContext).load(item.get(images.get(0)));
//            }

            TextView tvAuthor = helper.getView(R.id.tvAuthor);
            tvAuthor.setText(item.get(helper.getAdapterPosition()).getWho());

            TextView tvDays = helper.getView(R.id.tvDays);


        }



    }


}

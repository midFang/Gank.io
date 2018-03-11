package com.fangsf.gankio.ui.adapter;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fangsf.gankio.bean.VideoBean;
import com.fangsf.minddemo.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.model.GSYModel;
import com.shuyu.gsyvideoplayer.video.NormalGSYVideoPlayer;

import java.io.IOException;
import java.util.List;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by fangsf on 2018/3/11.
 * Useful:
 */

public class VideoAdapter extends BaseQuickAdapter<VideoBean.TrailersBean, BaseViewHolder> {

    public VideoAdapter(int layoutResId) {
        super(layoutResId);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(BaseViewHolder helper, VideoBean.TrailersBean item) {

        NormalGSYVideoPlayer view = helper.getView(R.id.normalGsyVideo);

        if (view != null) {


            view.initUIState();

            // 设置封面
            ImageView imageView = new ImageView(mContext);
            Glide.with(mContext).load(item.getCoverImg()).centerCrop().into(imageView);
            view.setThumbImageView(imageView);

            view.setUp(item.getUrl(), false, item.getMovieName());

            view.setReleaseWhenLossAudio(true);

            view.setShowFullAnimation(true);


        }


    }


}

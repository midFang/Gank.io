package com.fangsf.gankio.presenter.contract;

import com.fangsf.gankio.bean.VideoBean;
import com.fangsf.gankio.presenter.BaseView;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/3/11.
 * Useful:
 */

public class VideoContract {


    public interface IVideoView extends BaseView {

        void showData(VideoBean videoBean);

    }


    public interface IVideoModel {

        Observable<VideoBean> getVideoData();

    }


}

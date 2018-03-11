package com.fangsf.gankio.data;

import com.fangsf.gankio.bean.VideoBean;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.VideoContract;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/3/11.
 * Useful:
 */

public class VideoModel implements VideoContract.IVideoModel {

    private ApiServer mApiServer;

    public VideoModel(ApiServer apiServer) {
        mApiServer = apiServer;
    }

    @Override
    public Observable<VideoBean> getVideoData() {
        return mApiServer.getVideoData();
    }
}

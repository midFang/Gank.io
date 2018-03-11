package com.fangsf.gankio.di.module;

import com.fangsf.gankio.data.VideoModel;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.VideoContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fangsf on 2018/3/11.
 * Useful:
 */

@Module
public class VideoModule {

    public VideoContract.IVideoView mView;

    public VideoModule(VideoContract.IVideoView view) {
        mView = view;
    }

    @Provides
    public VideoContract.IVideoView provideView() {
        return mView;
    }

    @Provides
    public VideoContract.IVideoModel provideModel(ApiServer apiServer) {
        return new VideoModel(apiServer);
    }

}

package com.fangsf.gankio.presenter;

import android.util.Log;

import com.fangsf.gankio.bean.VideoBean;
import com.fangsf.gankio.common.rx.RxSchedulers;
import com.fangsf.gankio.presenter.contract.VideoContract;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by fangsf on 2018/3/11.
 * Useful:
 */

public class VideoPresenter extends BasePresneter<VideoContract.IVideoModel, VideoContract.IVideoView> {

    @Inject
    public VideoPresenter(VideoContract.IVideoModel model, VideoContract.IVideoView view) {
        super(model, view);
    }


    public void getVideoData() {

        mView.showLoading();

        mModel.getVideoData().compose(RxSchedulers.io_main()).subscribe(new Consumer<VideoBean>() {
            @Override
            public void accept(VideoBean videoBean) throws Exception {

                mView.showData(videoBean);


                mView.dismissLoading();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
                mView.showError(throwable.getMessage());
                Log.e(TAG, "accept: " + throwable.getMessage());

                mView.dismissLoading();
            }
        });

    }


}

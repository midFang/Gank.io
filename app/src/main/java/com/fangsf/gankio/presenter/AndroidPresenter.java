package com.fangsf.gankio.presenter;

import android.util.Log;
import android.widget.Toast;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.ResultBean;
import com.fangsf.gankio.common.rx.RxHttpResponseCompat;
import com.fangsf.gankio.common.rx.RxSchedulers;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.AndroidContract;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class AndroidPresenter extends BasePresneter<AndroidContract.IAndroidModel, AndroidContract.IAndroidView> {

    private int LOADMORE_COUNT = 10;

    @Inject
    public AndroidPresenter(AndroidContract.IAndroidModel model, AndroidContract.IAndroidView view) {
        super(model, view);
    }

    public void requestMoreData(int count) {
        if (count == LOADMORE_COUNT) {
            getAndroidData("Android", count, 1);
        } else if (count > LOADMORE_COUNT) {
            // loadMore
            getAndroidData("Android", count, 1);
        }
    }

    private void getAndroidData(String type, final int count, int pageSize) {

        mView.showLoading();

        mModel.getData(type, String.valueOf(count), String.valueOf(pageSize)).compose(RxHttpResponseCompat.<ArrayList<ResultBean>>composeResult())
                .subscribe(new Consumer<ArrayList<ResultBean>>() {
                    @Override
                    public void accept(ArrayList<ResultBean> resultBeans) throws Exception {
                        if (count == LOADMORE_COUNT) {
                            mView.showData(resultBeans);
                            mView.dismissLoading();
                        }

                        if ( count > LOADMORE_COUNT) {
                            mView.loadMore(resultBeans);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.dismissLoading();
                        mView.showError(throwable.getMessage());
                        throwable.printStackTrace();
                        Log.e(TAG, "accept: "+ throwable.getMessage() );
                    }
                });

        mView.dismissLoading();

    }


}

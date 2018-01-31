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

    @Inject
    public AndroidPresenter(AndroidContract.IAndroidModel model, AndroidContract.IAndroidView view) {
        super(model, view);
    }


    public void getAndroidData() {

        mModel.getData("Android", "15", "1").compose(RxHttpResponseCompat.<ArrayList<ResultBean>>composeResult())
                .subscribe(new Consumer<ArrayList<ResultBean>>() {
                    @Override
                    public void accept(ArrayList<ResultBean> resultBeans) throws Exception {
                        mView.showData(resultBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showError(throwable.getMessage());
                        throwable.printStackTrace();
                        Log.e(TAG, "accept: "+ throwable.getMessage() );
                    }
                });


    }


}

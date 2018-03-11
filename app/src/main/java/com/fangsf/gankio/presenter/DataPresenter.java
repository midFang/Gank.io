package com.fangsf.gankio.presenter;

import android.util.Log;

import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.common.rx.RxHttpResponseCompat;
import com.fangsf.gankio.presenter.contract.DatasContract;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class DataPresenter extends BasePresneter<DatasContract.IDatasModel, DatasContract.IDatasView> {

    private int LOAD_MORE_COUNT = 10;

    @Inject
    public DataPresenter(DatasContract.IDatasModel model, DatasContract.IDatasView view) {
        super(model, view);
    }

    public void requestData(String type,int count) {
        if (count == LOAD_MORE_COUNT) {
            getAndroidData(type, count, 1);
        } else if (count > LOAD_MORE_COUNT) {
            // loadMore
            getAndroidData(type, count, 1);
        }
    }

    private void getAndroidData(String type, final int count, int pageSize) {

        mModel.getData(type, String.valueOf(count), String.valueOf(pageSize)).compose(RxHttpResponseCompat.<ArrayList<DataBean>>composeResult())
                .subscribe(new Consumer<ArrayList<DataBean>>() {
                    @Override
                    public void accept(ArrayList<DataBean> dataBeans) throws Exception {
                        if (count == LOAD_MORE_COUNT) {
                            mView.showLoading();
                            mView.showData(dataBeans);
                        }

                        if ( count > LOAD_MORE_COUNT) {
                            mView.loadMore(dataBeans);
                        }

                        mView.dismissLoading();
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

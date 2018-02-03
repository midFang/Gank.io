package com.fangsf.gankio.presenter;

import android.util.Log;

import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.common.rx.RxHttpResponseCompat;
import com.fangsf.gankio.presenter.contract.RandomDataContract;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by fangsf on 2018/2/3.
 * Useful:
 */

public class RandomPresenter extends BasePresneter<RandomDataContract.IRandomDataModel, RandomDataContract.IRandomDataView> {


    @Inject
    public RandomPresenter(RandomDataContract.IRandomDataModel model, RandomDataContract.IRandomDataView view) {
        super(model, view);
    }


    public void getRandomData(String type, final String count) {

        mView.showLoading();

        mModel.getRandomData(type, count).compose(RxHttpResponseCompat.<ArrayList<RandomBean>>composeResult())
                .subscribe(new Consumer<ArrayList<RandomBean>>() {
                    @Override
                    public void accept(ArrayList<RandomBean> randomBeans) throws Exception {
                        mView.showData(randomBeans);

                        mView.dismissLoading();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        Log.e(TAG, "accept: " + throwable.getMessage());

                        mView.showError(throwable.getMessage());
                        mView.dismissLoading();
                    }
                });

    }


}

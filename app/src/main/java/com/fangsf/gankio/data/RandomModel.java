package com.fangsf.gankio.data;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.RandomDataContract;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by fangsf  on 2018/2/3.
 * Useful: 具体实现模块层
 */

public class RandomModel implements RandomDataContract.IRandomDataModel {

    private ApiServer mApiServer;

    public RandomModel(ApiServer apiServer) {
        mApiServer = apiServer;
    }

    @Override
    public Observable<BaseBean<ArrayList<RandomBean>>> getRandomData(String type, String count) {
        return mApiServer.getRandomData(type, count);
    }

}

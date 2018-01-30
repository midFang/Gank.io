package com.fangsf.gankio.data;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.ResultBean;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.AndroidContract;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class AndroidModel implements AndroidContract.IAndroidModel {

    private ApiServer mApiServer;

    public AndroidModel(ApiServer apiServer) {
        mApiServer = apiServer;
    }

    @Override
    public Observable<BaseBean<ArrayList<ResultBean>>> getData(String type, String count, String pageSize) {
        return mApiServer.getData(type, count, pageSize);
    }
}

package com.fangsf.gankio.data;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.presenter.contract.DatasContract;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class DatasModel implements DatasContract.IDatasModel{

    private ApiServer mApiServer;

    public DatasModel(ApiServer apiServer) {
        mApiServer = apiServer;
    }

    @Override
    public Observable<BaseBean<ArrayList<DataBean>>> getData(String type, String count, String pageSize) {
        return mApiServer.getData(type, count, pageSize);
    }
}

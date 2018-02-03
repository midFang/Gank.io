package com.fangsf.gankio.presenter.contract;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.presenter.BaseView;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/2/3.
 * Useful:
 */

public class RandomDataContract {


    public interface IRandomDataView extends BaseView {
        void showData(ArrayList<RandomBean> randomBean);
    }


    public interface IRandomDataModel {
        Observable<BaseBean<ArrayList<RandomBean>>> getRandomData(String type, String count);
    }


}

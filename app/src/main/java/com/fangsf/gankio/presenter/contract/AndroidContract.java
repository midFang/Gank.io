package com.fangsf.gankio.presenter.contract;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.ResultBean;
import com.fangsf.gankio.presenter.BaseView;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class AndroidContract {


   public interface IAndroidView extends BaseView {

    }

   public interface IAndroidModel{
        Observable<BaseBean<ArrayList<ResultBean>>> getData(String type, String count, String pageSize);
    }
}

package com.fangsf.gankio.presenter.contract;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.presenter.BaseView;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class DatasContract {


   public interface IDatasView extends BaseView {

       void showData(ArrayList<DataBean> dataBeans);

       void loadMore(ArrayList<DataBean> dataBeans);
   }

   public interface IDatasModel{
        Observable<BaseBean<ArrayList<DataBean>>> getData(String type, String count, String pageSize);
    }
}

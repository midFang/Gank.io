package com.fangsf.gankio.data.http;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.bean.RandomBean;

import java.util.ArrayList;
import java.util.Random;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public interface ApiServer {

    String BASE_URL = "http://gank.io/api/";

    /**
     * @param type     数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param count    请求个数： 数字，大于0
     * @param pageSize 第几页：数字，大于0
     */
    @GET("data/{type}/{count}/{pageSize}")
    Observable<BaseBean<ArrayList<DataBean>>> getData(@Path("type") String type, @Path("count") String count, @Path("pageSize") String pageSize);


    /**
     * 获取随机数据
     */
    @GET("random/data/{type}/{count}")
    Observable<BaseBean<ArrayList<RandomBean>>> getRandomData(@Path("type") String type, @Path("count") String count);


}

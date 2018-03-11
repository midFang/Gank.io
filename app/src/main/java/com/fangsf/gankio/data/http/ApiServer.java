package com.fangsf.gankio.data.http;

import com.fangsf.gankio.bean.BaseBean;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.bean.DayInfo;
import com.fangsf.gankio.bean.RandomBean;
import com.fangsf.gankio.bean.VideoBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public interface ApiServer {

    String BASE_URL = "http://gank.io/api/";
    String BASE_URL_VIDEO = "http://api.m.mtime.cn/";

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


    /**
     * 获取 往期 干货推荐 日期
     */
    @GET("day/history")
    Observable<BaseBean<ArrayList<String>>> getHistoriesDay();

    /**
     * 获取 历史推荐干货
     */
    @GET("day/{date}")
    Observable<DayInfo> getHistoriesRecommend(@Path("date") String date);


    /**
     * 获取视频
     */
    @Headers("bqs_auth:video")
    @GET("PageSubArea/TrailerList.api")
    Observable<VideoBean> getVideoData();


}

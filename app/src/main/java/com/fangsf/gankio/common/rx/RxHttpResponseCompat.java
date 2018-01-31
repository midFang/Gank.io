package com.fangsf.gankio.common.rx;

import com.bumptech.glide.Glide;
import com.fangsf.gankio.bean.BaseBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class RxHttpResponseCompat {

    public static <T> ObservableTransformer<BaseBean<T>, T> composeResult() {

        return new ObservableTransformer<BaseBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseBean<T>> upstream) {
                //转换
                return upstream.flatMap(new Function<BaseBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(final BaseBean<T> tBaseBean) throws Exception {

                        if (!tBaseBean.isError()) {
                            //发射器
                            return Observable.create(new ObservableOnSubscribe<T>() {
                                @Override
                                public void subscribe(ObservableEmitter<T> e) throws Exception {
                                    try {
                                        e.onNext(tBaseBean.getResults());
                                        e.onComplete();
                                    } catch (Exception e1) {
                                        e1.printStackTrace();
                                        e.onError(e1);
                                    }
                                }
                            });
                        } else {
                            // 自定义rx异常处理
//                            return Observable.error()
                            return Observable.empty();
//                            return null;
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };

    }

}

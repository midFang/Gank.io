package com.fangsf.gankio.presenter;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public interface BaseView {
    void showLoading();

    void showError(String mes);

    void dissmissLoading();
}

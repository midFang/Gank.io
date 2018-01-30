package com.fangsf.gankio.bean;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class BaseBean<T> {

    boolean error;
    T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}

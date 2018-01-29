package com.fangsf.gankio.bean;

/**
 * Created by fangsf on 2018/1/29.
 * Useful:
 */

public class FragmentInfo {


    private String title;
    private Class fragment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }

    public FragmentInfo(String title, Class fragment) {
        this.title = title;
        this.fragment = fragment;
    }
}

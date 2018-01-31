package com.fangsf.gankio.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import javax.inject.Singleton;

/**
 * @author fangsf
 * @date 2017/12/26.
 * @useful:  创建 属于自己的单例 singleton, todo 怎么是
 */

@Scope
@Singleton
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {

}
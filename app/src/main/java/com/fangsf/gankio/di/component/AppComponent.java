package com.fangsf.gankio.di.component;

import android.app.Application;

import com.fangsf.gankio.data.http.ApiServer;
import com.fangsf.gankio.di.module.AppModule;
import com.fangsf.gankio.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    ApiServer getApiserver();

    Application getApplication();

}

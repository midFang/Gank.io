package com.fangsf.gankio;

import android.app.Application;
import android.content.Context;
import android.view.View;

import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.di.component.DaggerAppComponent;
import com.fangsf.gankio.di.module.AppModule;
import com.fangsf.gankio.di.module.HttpModule;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    private View mView;

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public View getView() {
        return mView;
    }

    public void setView(View view) {
        mView = view;
    }

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();

    }
}

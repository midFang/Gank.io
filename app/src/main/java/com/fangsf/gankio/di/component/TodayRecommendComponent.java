package com.fangsf.gankio.di.component;

import com.fangsf.gankio.di.FragmentScope;
import com.fangsf.gankio.di.module.TodayRecommendModule;
import com.fangsf.gankio.ui.activity.TodayRecommendActivity;

import dagger.Component;

/**
 * Created by fangsf on 2018/2/4.
 * Useful:
 */

@FragmentScope
@Component(modules = TodayRecommendModule.class, dependencies = AppComponent.class)
public interface TodayRecommendComponent {


    void inject(TodayRecommendActivity activity);


}

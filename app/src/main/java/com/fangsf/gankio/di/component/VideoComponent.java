package com.fangsf.gankio.di.component;

import com.fangsf.gankio.di.FragmentScope;
import com.fangsf.gankio.di.module.HttpModule;
import com.fangsf.gankio.di.module.VideoModule;
import com.fangsf.gankio.ui.fragment.hometab.VideoFragment;

import dagger.Component;
import dagger.Module;

/**
 * Created by fangsf on 2018/3/11.
 * Useful:
 */

@FragmentScope
@Component(modules = VideoModule.class, dependencies = AppComponent.class)
public interface VideoComponent {

    void inject(VideoFragment fragment);

}

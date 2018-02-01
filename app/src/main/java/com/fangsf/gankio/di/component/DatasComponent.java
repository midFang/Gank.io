package com.fangsf.gankio.di.component;

import com.fangsf.gankio.di.FragmentScope;
import com.fangsf.gankio.di.module.DatasModule;
import com.fangsf.gankio.ui.fragment.AndroidFragment;
import com.fangsf.gankio.ui.fragment.IOSFragment;

import dagger.Component;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

@FragmentScope
@Component(modules = DatasModule.class, dependencies = AppComponent.class)
public interface DatasComponent {

    void inject(AndroidFragment fragment);

    void inject(IOSFragment fragment);

}

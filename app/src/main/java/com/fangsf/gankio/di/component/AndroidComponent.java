package com.fangsf.gankio.di.component;

import com.fangsf.gankio.di.FragmentScope;
import com.fangsf.gankio.di.module.AndroidModule;
import com.fangsf.gankio.ui.fragment.AndroidFragment;

import dagger.Component;

/**
 * Created by fangsf on 2018/1/30.
 * Useful:
 */

@FragmentScope
@Component(modules = AndroidModule.class, dependencies = AppComponent.class)
public interface AndroidComponent {

    void inject(AndroidFragment fragment);

}

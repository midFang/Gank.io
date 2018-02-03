package com.fangsf.gankio.di.component;

import com.fangsf.gankio.di.FragmentScope;
import com.fangsf.gankio.di.module.RandomDataModule;
import com.fangsf.gankio.ui.activity.MainActivity;
import com.fangsf.gankio.ui.fragment.hometab.MzFragment;

import dagger.Component;

/**
 * Created by fangsf on 2018/2/3.
 * Useful:
 */

@FragmentScope
@Component(modules = RandomDataModule.class, dependencies = AppComponent.class)
public interface RandomDataComponent {

    void inject(MainActivity activity);


    void inject(MzFragment fragment);

}

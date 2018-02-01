package com.fangsf.gankio.ui.fragment.hometab;

import com.fangsf.gankio.di.component.AppComponent;
import com.fangsf.gankio.di.component.DaggerDatasComponent;
import com.fangsf.gankio.di.module.DatasModule;

/**
 * @author fangsf
 * @date 2018/1/5.
 * @useful:
 */

public class AndroidFragment extends DatasFragment {


    @Override
    protected int loadCount() {
        return 10;
    }

    @Override
    protected String type() {
        return "Android";
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerDatasComponent.builder().appComponent(appComponent)
                .datasModule(new DatasModule(this))
                .build().inject(this);
    }
}

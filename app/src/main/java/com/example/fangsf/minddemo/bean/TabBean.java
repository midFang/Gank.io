package com.example.fangsf.minddemo.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * @author fangsf
 * @date 2018/1/5.
 * @useful:
 */

public class TabBean implements CustomTabEntity {

    private int selectedIcon;
    private int unselectedIcon;
    private String title;
    
    public TabBean(int selectedIcon, int unselectedIcon, String title) {
        this.selectedIcon = selectedIcon;
        this.unselectedIcon = unselectedIcon;
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselectedIcon;
    }
}

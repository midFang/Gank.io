package com.fangsf.gankio.ui.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.fangsf.gankio.bean.DataBean;
import com.fangsf.gankio.common.Constant;
import com.fangsf.gankio.ui.activity.GankWebActivity;
import com.fangsf.minddemo.R;

import java.io.File;

import io.reactivex.Flowable;

/**
 * Created by fangsf on 2018/2/6.
 * Useful:
 */

public class SettingFragment extends PreferenceFragment {

    private Preference github;
    private Preference author;
    private Preference cache;
    private Preference version;

    private File cacheFile;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_setting);

        github = findPreference("github");
        author = findPreference("author");
        cache = findPreference("cache");
        version = findPreference("currentVersion");

        //图片缓存目录
        cacheFile = new File(getActivity().getCacheDir(), DiskCache.Factory.DEFAULT_DISK_CACHE_DIR);

        long l = calculateSize(cacheFile);

        long size = 0;

        String sizeText = android.text.format.Formatter.formatFileSize(getActivity(), size);
        cache.setSummary(String.valueOf(l));

        initListener();

        version.setSummary(getVersion());


    }

    /**
     * 算出当前目录下所有文件的大小
     *
     * @param dir
     * @return
     */
    private long calculateSize(File dir) {
        if (dir == null) return 0;
        if (!dir.isDirectory()) return dir.length();
        long result = 0;
        File[] children = dir.listFiles();
        if (children != null)
            for (File child : children)
                result += calculateSize(child);
        return result;
    }

    private void initListener() {

        github.setOnPreferenceClickListener(preference -> {
            jumpWebAct(github.getSummary());
            return false;
        });

        cache.setOnPreferenceClickListener(preference -> {
            Toast.makeText(getActivity(), ".....", Toast.LENGTH_SHORT).show();

            return false;
        });

    }


    private void jumpWebAct(CharSequence summary) {
        DataBean dataBean = new DataBean();
        dataBean.setDesc("Github");
        dataBean.setUrl(summary.toString());
        Intent intent = new Intent(getActivity(), GankWebActivity.class);
        intent.putExtra(Constant.WEB_DATA_BEAN, dataBean);
        startActivity(intent);
    }

    private String getVersion() {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = getActivity().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getActivity().getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }
}

package com.fangsf.gankio.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author fangsf
 * @date 2017/11/23.
 */

public abstract class BaseFragment extends Fragment {

    private boolean isDebug = false;
    private final String TAG = this.getClass().getSimpleName();

    private View mContextView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        $Log(TAG + "--->onCreateView()");

        mContextView = inflater.inflate(bindLayout(), container, false);
       init();
        return mContextView;

    }

    protected abstract void init();

    protected abstract int bindLayout();

    private void $Log(String mes) {
        if (isDebug) {
            Log.d(TAG, mes);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        $Log(TAG + "--->onDestroy()");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        $Log(TAG + "--->onDestroy()");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $Log(TAG + "--->onCreate()");
    }


    @Override
    public void onStart() {
        super.onStart();
        $Log(TAG + "--->onStart()");
    }


    @Override
    public void onStop() {
        super.onStop();
        $Log(TAG + "--->onStop()");
    }

    @Override
    public void onPause() {
        super.onPause();
        $Log(TAG + "--->onPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        $Log(TAG + "--->onResume()");
    }
}

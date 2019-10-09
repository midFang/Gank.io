package com.fangsf.gankio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by fangsf on 2019-10-09
 * Useful:
 */
abstract class BaseFragment : androidx.fragment.app.Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(bindLayout(), container, false)
    }

    abstract fun bindLayout(): Int

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    abstract fun init()


}
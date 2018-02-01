package com.fangsf.gankio.common.utils;

import android.content.Context;
import android.text.format.DateUtils;

import com.fangsf.minddemo.R;

/**
 * Created by fangsf on 2018/2/1.
 * Useful: 相对时间
 */

public class RelateTimeUtil {


    /**
     * @param context
     * @param oldTime 相对时间的过去时间 1517212437000
     * @return
     */
    public static CharSequence getRelativeTime(Context context, long oldTime) {
        long now = System.currentTimeMillis();
        long difference = now - oldTime;
        if (difference >= 0 && difference < DateUtils.MINUTE_IN_MILLIS)
            return context.getResources().getString(R.string.just_now);
        else
            return DateUtils.getRelativeTimeSpanString(oldTime, now, DateUtils.MINUTE_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE);

    }

}

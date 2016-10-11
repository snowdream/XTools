package com.github.snowdream.xtools.util;

import android.util.Log;

import com.github.snowdream.xtools.BuildConfig;


/**
 * Created by snowdream on 16-8-31.
 */
public final class LogUtil {
    private static final String ALL_TAG = "SnowdreamFramework";
    public static final String TAG = "Xposed";

    public static void log(String tag, String str) {
        if (!BuildConfig.DEBUG) return;

        StringBuilder builder = new StringBuilder();
        builder.append(ALL_TAG);
        builder.append("    ");
        builder.append(tag);
        builder.append("    ");
        builder.append(str);

        Log.i(TAG, builder.toString());
    }

    public static void log(String tag, Throwable throwable) {
        if (!BuildConfig.DEBUG) return;

        StringBuilder builder = new StringBuilder();
        builder.append(ALL_TAG);
        builder.append("    ");
        builder.append(tag);
        builder.append("    ");

        Log.i(TAG, builder.toString());
        Log.i(TAG, Log.getStackTraceString(throwable));
    }
}

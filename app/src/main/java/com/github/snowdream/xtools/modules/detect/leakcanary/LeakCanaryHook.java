package com.github.snowdream.xtools.modules.detect.leakcanary;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.github.snowdream.xtools.modules.detect.blockcanary.BlockCanaryHook;
import com.github.snowdream.xtools.util.LogUtil;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;


/**
 * see: LeakCanary  https://github.com/square/leakcanary/
 *
 * Created by snowdream on 16-10-15.
 */

public class LeakCanaryHook {
    private static final String TAG = LeakCanaryHook.class.getSimpleName();

    public static void hook(@NonNull Application app, @NonNull final ClassLoader classLoader) throws Throwable {
        LogUtil.log(TAG, "hook");

        if (LeakCanary.isInAnalyzerProcess(app)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        RefWatcher refWatcher = hookActivity(app);

        hookFragment(refWatcher);
    }

    private static RefWatcher hookActivity(@NonNull Application app) throws Throwable {
        return LeakCanary.install(app);
    }

    private static void hookFragment(@NonNull final RefWatcher refWatcher) throws Throwable {
        XposedHelpers.findAndHookMethod(android.support.v4.app.Fragment.class, "onDestroy",new XC_MethodHook() {
            @Override
            public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                LogUtil.log(TAG, "android.support.v4.app.Fragment - onDestroy");

                if (param.thisObject != null) {
                    refWatcher.watch(param.thisObject);
                }
            }
        });

        XposedHelpers.findAndHookMethod(android.app.Fragment.class, "onDestroy",new XC_MethodHook() {
            @Override
            public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                LogUtil.log(TAG, "android.app.Fragment - onDestroy");

                if (param.thisObject != null) {
                    refWatcher.watch(param.thisObject);
                }
            }
        });
    }
}

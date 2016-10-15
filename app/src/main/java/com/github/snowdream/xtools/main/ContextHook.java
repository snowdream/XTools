package com.github.snowdream.xtools.main;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.github.snowdream.xtools.modules.detect.blockcanary.BlockCanaryHook;
import com.github.snowdream.xtools.modules.detect.leakcanary.LeakCanaryHook;
import com.github.snowdream.xtools.util.LogUtil;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/**
 * Created by snowdream on 16-10-7.
 */
public class ContextHook {
    private static final String TAG = ContextHook.class.getSimpleName();

    public static void hook(@NonNull final ClassLoader classLoader) {
//        LogUtil.log(TAG, "hookContext");

        XposedHelpers.findAndHookMethod(Application.class, "onCreate",new XC_MethodHook() {
            @Override
            public void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                LogUtil.log(TAG, "onCreate");
                if (param.thisObject instanceof Application ){
                    Application app = (Application)param.thisObject;
                    LogUtil.log(TAG, app.getPackageName());

                    Context context = app.getApplicationContext();

                    //hook blockcanary
                    BlockCanaryHook.hook(context, classLoader);

                    //hook leakcanary
                    LeakCanaryHook.hook(app, classLoader);
                }
            }
        });
    }
}
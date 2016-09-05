package com.github.snowdream.xtest.xposed;

import android.app.AndroidAppHelper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.github.snowdream.xtest.core.Settings;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;

/**
 * Created by snowdream on 16-9-5.
 */
public class XTest_MethodHook extends XC_MethodHook{
    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
    }


    /**
     * Avoid hook method in system code
     *
     * @param param
     * @return
     */
    protected boolean shouldMethodHooked(@NonNull MethodHookParam param){
        Class clazz = param.method.getDeclaringClass();

        log(param,"shouldMethodHooked"+" "+ AndroidAppHelper.currentPackageName()+" "+AndroidAppHelper.currentProcessName());
        return Settings.shouldMethodHooked(clazz);
    }

    /**
     * log method info which be hooked
     *
     * @param param
     */
    protected void log(@NonNull MethodHookParam param, String desc){
        StringBuilder builder = new StringBuilder();
        builder.append("packagename:");
        builder.append(param.method.getDeclaringClass().getPackage().getName());
        builder.append("\tclassname:");
        builder.append(param.method.getDeclaringClass().getName());
        builder.append("\tmethod:");
        builder.append(param.method.getName());

        if (!TextUtils.isEmpty(desc)){
            builder.append("\tdesc:");
            builder.append(desc);
        }

        XposedBridge.log(builder.toString());
    }
}

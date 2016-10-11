package com.github.snowdream.xtools.xposed;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;

/**
 * Created by snowdream on 16-9-5.
 */
public class XTools_MethodHook extends XC_MethodHook{
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
    protected boolean isFromAllowedPackage(@NonNull MethodHookParam param){
        int index = 6;

        String className = Thread.currentThread().getStackTrace()[index].getClassName();

        if (TextUtils.isEmpty(className)) return false;

        return className.contains("com.github.snowdream.xtools");
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

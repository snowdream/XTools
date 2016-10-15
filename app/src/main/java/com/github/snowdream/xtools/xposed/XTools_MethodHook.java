package com.github.snowdream.xtools.xposed;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.github.snowdream.xtools.main.Settings;
import com.github.snowdream.xtools.util.LogUtil;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;

/**
 * Created by snowdream on 16-9-5.
 */
public class XTools_MethodHook extends XC_MethodHook {
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
     * <p>
     * Do not call it yourself.
     *
     * @param param
     * @return
     */
    protected boolean isFromAllowedPackage(@NonNull MethodHookParam param) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        if (elements == null || elements.length == 0) return false;

        String paramClassName = param.method.getDeclaringClass().getName();
        String paramMethodName = param.method.getName();

        int index = 0;
        int size = elements.length;
        for (int i = 0; i < size; i++) {
            index++;

            StackTraceElement element = elements[i];

            if (element == null) continue;

            String className = element.getClassName();
            String methodName = element.getMethodName();

            if (className.equalsIgnoreCase(paramClassName) &&
                    methodName.equalsIgnoreCase(paramMethodName)) {
                break;
            }
        }

        StackTraceElement element = elements[index];
        String className = element.getClassName();

        if (TextUtils.isEmpty(className)) return false;

        return Settings.isFromAllowedPackage(className);
    }

    /**
     * Avoid hook method in system code
     * <p>
     * Do not call it yourself.
     *
     * @param param
     * @return
     */
    protected boolean shouldNotHook(@NonNull MethodHookParam param) {
        return false;
    }

    /**
     * call it at the first of beforeHookedMethod and afterHookedMethod
     *
     * @param param
     * @return
     */
    final protected boolean isHook(@NonNull MethodHookParam param) {
        return isFromAllowedPackage(param) && !shouldNotHook(param);
    }


    /**
     * log method info which be hooked
     *
     * @param param
     */
    protected void log(@NonNull MethodHookParam param, String desc) {
        StringBuilder builder = new StringBuilder();
        builder.append("packagename:");
        builder.append(param.method.getDeclaringClass().getPackage().getName());
        builder.append("\tclassname:");
        builder.append(param.method.getDeclaringClass().getName());
        builder.append("\tmethod:");
        builder.append(param.method.getName());

        if (!TextUtils.isEmpty(desc)) {
            builder.append("\tdesc:");
            builder.append(desc);
        }

        XposedBridge.log(builder.toString());
    }
}

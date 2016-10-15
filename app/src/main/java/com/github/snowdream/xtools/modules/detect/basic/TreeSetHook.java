package com.github.snowdream.xtools.modules.detect.basic;

import android.support.annotation.NonNull;

import com.github.snowdream.xtools.xposed.XTools_MethodHook;

import de.robv.android.xposed.XposedHelpers;

/**
 * Created by snowdream on 16-9-4.
 */
public final class TreeSetHook {

    private static final String CLASS_NAME = "java.util.TreeSet";

    public static void hook(@NonNull final ClassLoader classLoader) throws Throwable {
        forceEmptySize(classLoader);
    }

    private static void forceEmptySize(@NonNull final ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "isEmpty", new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(true);
                //log(param, "ArrayListHook: forceEmptySize  isEmpty-true ");
            }
        });


        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "size", new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(0);
                //log(param, "ArrayListHook: forceEmptySize  size == 0 ");
            }
        });
    }
}

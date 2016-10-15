package com.github.snowdream.xtools.modules.detect.basic;

import android.support.annotation.NonNull;

import com.github.snowdream.xtools.xposed.XTools_MethodHook;

import de.robv.android.xposed.XposedHelpers;

/**
 * Created by snowdream on 16-10-15.
 */

public class JSONObjectHook {

    private static final String CLASS_NAME = "org.json.JSONObject";

    public static void hook(@NonNull final ClassLoader classLoader) throws Throwable {
        //get
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "get", String.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(null);
            }
        });

        //getBoolean
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "getBoolean", String.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(null);
            }
        });

        //getDouble
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "getDouble", String.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(null);
            }
        });

        //getInt
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "getInt", String.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(null);
            }
        });

        //JSONArray
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "getJSONArray", String.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(null);
            }
        });

        //getJSONObject
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "getJSONObject", String.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(null);
            }
        });

        //getLong
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "getLong", String.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(null);
            }
        });

        //getString
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "getString", String.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isHook(param)) return;

                param.setResult(null);
            }
        });
    }
}

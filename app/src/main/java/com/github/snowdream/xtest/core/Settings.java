package com.github.snowdream.xtest.core;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import de.robv.android.xposed.XC_MethodHook;

/**
 * Created by snowdream on 16-9-4.
 */
public class Settings {
    public static int mode = Mode.STRICT;


    /**
     * just hook class from special package.
     *
     * @param clazz
     * @return
     */
    public static boolean shouldMethodHooked(@NonNull Class clazz) {
        String packagename = clazz.getPackage().getName();

        if (TextUtils.isEmpty(packagename) && packagename.contains(Main.HOOKED_PACKAGE_NAME)) {
            return true;
        }

        return false;
    }
}


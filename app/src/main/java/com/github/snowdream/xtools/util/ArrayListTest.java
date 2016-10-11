package com.github.snowdream.xtools.util;

import android.support.annotation.NonNull;
import com.github.snowdream.xtools.base.Mode;
import com.github.snowdream.xtools.xposed.XTools_MethodHook;
import de.robv.android.xposed.XposedHelpers;

import static com.github.snowdream.xtools.base.Settings.mode;

/**
 * Created by snowdream on 16-9-4.
 */
public final class ArrayListTest {
    private static final String CLASS_NAME = "java.util.ArrayList";

    public static void handleLoadPackage(@NonNull final ClassLoader classLoader) throws Throwable {
        forceEmptySize(classLoader);

        if (mode == Mode.STRICT) {
            forceEmptyItem(classLoader);
        }
    }


    private static void forceEmptySize(@NonNull final ClassLoader classLoader) {

        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "isEmpty", new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isFromAllowedPackage(param)) return;

                if (param.thisObject != null) {
                    XposedHelpers.setIntField(param.thisObject, "size",0);
                }

                param.setResult(true);
                log(param,"ArrayListTest: forceEmptySize  isEmpty-true ");
            }
        });
    }

    /**
     * Force empty item
     *
     * @param classLoader
     */
    private static void forceEmptyItem(@NonNull final ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod(CLASS_NAME, classLoader, "get", int.class, new XTools_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                if (!isFromAllowedPackage(param)) return;

                param.setResult(null);
                log(param,"ArrayListTest: forceEmptyItem");
            }
        });
    }
}

package com.github.snowdream.xtools.main;

import android.app.Application;
import com.github.snowdream.xtools.util.ArrayListTest;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by snowdream on 16-8-30.
 */
public class Main implements IXposedHookLoadPackage {
    public static final String HOOKED_PACKAGE_NAME = "com.github.snowdream.xtools";

    /**
     * This method is called when an app is loaded. It's called very early, even before
     * {@link Application#onCreate} is called.
     * Modules can set up their app-specific hooks here.
     *
     * @param lpparam Information about the app.
     * @throws Throwable Everything the callback throws is caught and logged.
     */
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(HOOKED_PACKAGE_NAME))
            return;

        XposedBridge.log("XTools Launch app: " + lpparam.packageName);

        //util
//        ArrayListTest.handleLoadPackage(lpparam.classLoader);

        XposedBridge.log("XTools  handleLoadPackage finish.");

    }

}

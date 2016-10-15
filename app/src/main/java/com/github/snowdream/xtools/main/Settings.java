package com.github.snowdream.xtools.main;

import android.support.annotation.NonNull;

/**
 * Created by snowdream on 16-9-4.
 */
public class Settings {
    public static int mode = Mode.STRICT;

    public static String packageName = "com.github.snowdream.xtools";


    public static boolean isStrictMode(){
        return mode == Mode.STRICT;
    }

    public static boolean isFromAllowedPackage(@NonNull String className){
        return className.contains(packageName);
    }
}


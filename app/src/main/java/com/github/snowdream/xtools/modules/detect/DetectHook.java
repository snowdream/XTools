package com.github.snowdream.xtools.modules.detect;

import android.support.annotation.NonNull;

import com.github.snowdream.xtools.modules.detect.basic.ArrayListHook;
import com.github.snowdream.xtools.modules.detect.basic.HashMapHook;
import com.github.snowdream.xtools.modules.detect.basic.HashSetHook;
import com.github.snowdream.xtools.modules.detect.basic.JSONArrayHook;
import com.github.snowdream.xtools.modules.detect.basic.JSONObjectHook;
import com.github.snowdream.xtools.modules.detect.basic.LinkedListHook;
import com.github.snowdream.xtools.modules.detect.basic.TreeMapHook;
import com.github.snowdream.xtools.modules.detect.basic.TreeSetHook;

/**
 *
 * Created by snowdream on 16-10-12.
 */

public class DetectHook {

    public static void hook(@NonNull final ClassLoader classLoader) throws Throwable {
        //util
        ArrayListHook.hook(classLoader);
        LinkedListHook.hook(classLoader);
        HashSetHook.hook(classLoader);
        TreeSetHook.hook(classLoader);
        HashMapHook.hook(classLoader);
        TreeMapHook.hook(classLoader);

        //json
        JSONObjectHook.hook(classLoader);
        JSONArrayHook.hook(classLoader);
    }
}

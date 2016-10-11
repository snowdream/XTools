package com.github.snowdream.xtools.modules.detect.basic;

import android.support.v4.app.Fragment;

import com.github.snowdream.xtools.base.module.Module;
import com.github.snowdream.xtools.modules.detect.DetectFragment;

import java.util.List;

/**
 * Created by snowdream on 16-10-11.
 */

public class BasicDetectModule extends Module<DetectFragment> {
    @Override
    public int getNameResID() {
        return 0;
    }

    @Override
    public int getDescResID() {
        return 0;
    }

    @Override
    public int getIconResID() {
        return 0;
    }

    @Override
    public boolean isXposedSupported() {
        return false;
    }

    @Override
    public Class<Fragment> getTarget() {
        return null;
    }

    @Override
    public List<Module> getSubModules() {
        return null;
    }
}

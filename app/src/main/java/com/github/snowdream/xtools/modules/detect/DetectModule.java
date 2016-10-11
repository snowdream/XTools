package com.github.snowdream.xtools.modules.detect;

import android.support.v4.app.Fragment;

import com.github.snowdream.xtools.R;
import com.github.snowdream.xtools.base.module.Module;

import java.util.List;

/**
 * Created by snowdream on 16-10-11.
 */

public class  DetectModule extends Module<DetectFragment> {
    @Override
    public int getNameResID() {
        return R.string.module_detect_name;
    }

    @Override
    public int getDescResID() {
        return R.string.module_detect_desc;
    }

    @Override
    public int getIconResID() {
        return R.mipmap.ic_launcher;
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

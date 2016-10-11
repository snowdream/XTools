package com.github.snowdream.xtools.base.module;

import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * moudle interface
 * <p>
 * Created by snowdream on 16-10-11.
 */

public abstract class Module<T extends Fragment> {
    public static final int LEVEL_TOP = 0;
    public static final int LEVEL_MIDDLE = 1;
    public static final int LEVEL_BOTTOM = 2;

    @IntDef({LEVEL_TOP, LEVEL_MIDDLE, LEVEL_BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LEVEL {
    }

    private int mLevel = LEVEL_TOP;

    public Module() {
    }

    public Module(@LEVEL int level) {
        mLevel = level;
    }


    public
    @StringRes
    abstract int getNameResID();

    public
    @StringRes
    abstract int getDescResID();

    public
    @DrawableRes
    abstract int getIconResID();

    public abstract boolean isXposedSupported();

    public abstract Class<Fragment> getTarget();

    public
    @LEVEL
    int getLevel() {
        return mLevel;
    }

    public abstract List<Module> getSubModules();

    public boolean isAvailable(){
        return true;
    };
}

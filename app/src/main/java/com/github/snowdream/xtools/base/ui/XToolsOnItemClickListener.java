package com.github.snowdream.xtools.base.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;

import com.github.snowdream.xtools.R;
import com.github.snowdream.xtools.base.module.Module;
import com.github.snowdream.xtools.util.LogUtil;

/**
 * XToolsOnItemClickListener
 *
 * Created by snowdream on 16-10-11.
 */

public class XToolsOnItemClickListener<T extends Module>  implements AdapterView.OnItemClickListener {
    private static final String TAG = XToolsOnItemClickListener.class.getSimpleName();

    private FragmentManager manager;
    private Context mContext;
    private BaseGridAdapter mBaseAdapter;

    public XToolsOnItemClickListener(@NonNull FragmentActivity activity, @NonNull BaseGridAdapter baseAdapter) {
        this.manager = activity.getSupportFragmentManager();
        this.mContext = activity;
        this.mBaseAdapter = baseAdapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Module module = mBaseAdapter.getItem(position);

        if (module == null) return;

        Class<Fragment> fragmentClass = module.getTarget();

        if (fragmentClass == null) {

            LogUtil.log(TAG, "The Module " + mContext.getString(module.getNameResID()) + " has no target.");
            return;
        }

        Fragment fragment;
        try {
            fragment = fragmentClass.newInstance();

            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            fragmentTransaction.add(R.id.container, fragment);
            fragmentTransaction.commit();

        } catch (InstantiationException e) {
            LogUtil.log(TAG,e);
        } catch (IllegalAccessException e) {
            LogUtil.log(TAG,e);
        }
    }
}

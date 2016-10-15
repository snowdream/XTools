package com.github.snowdream.xtools.base.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.snowdream.xtools.R;
import com.github.snowdream.xtools.base.module.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snowdream on 16-10-11.
 */

public class BaseGridAdapter extends BaseAdapter {
    private List<Module> mList;
    private LayoutInflater mInflater;

    public BaseGridAdapter(@NonNull Context context, @NonNull List<Module> list) {
        mInflater = LayoutInflater.from(context);
        setData(list, false);
    }

    public void setData(@NonNull List<Module> list) {
        setData(list, true);
    }

    private void setData(@NonNull List<Module> list, boolean isRefresh) {
        List<Module> modules = new ArrayList<>();

        for (Module module : list) {
            if (module == null) continue;

            if (!module.isAvailable()) continue;

            modules.add(module);
        }

        mList = modules;

        if (isRefresh) {
            notifyDataSetInvalidated();
        }
    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }

        return 0;
    }

    @Override
    public Module getItem(int position) {
        if (getCount() == 0 || position < 0 || position >= getCount()) {
            return null;
        }

        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Module module = getItem(position);
        if (module == null) return null;

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.module_grid_item, null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            holder.textView = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (module.getIconResID() > 0) {
            holder.imageView.setImageResource(module.getIconResID());
        } else {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        }

        if (module.getNameResID() > 0) {
            holder.textView.setText(module.getNameResID());
        } else {
            holder.textView.setText(R.string.module);
        }


        return convertView;
    }


    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}

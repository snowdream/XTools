package com.github.snowdream.xtools.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.github.snowdream.xtools.R;
import com.github.snowdream.xtools.base.module.Module;
import com.github.snowdream.xtools.modules.detect.DetectModule;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseGridFragment
 * <p>
 * Created by snowdream on 16-10-11.
 */
public class BaseGridFragment extends BaseFragment {
    protected GridView mGridView = null;
    protected BaseGridAdapter mAdapter = null;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base_grid, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mGridView = (GridView) view.findViewById(R.id.gridview);


        mAdapter = new BaseGridAdapter(getContext(), getModules());
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new XToolsOnItemClickListener(getActivity(), mAdapter));
    }

    public List<Module> getModules(){
        List<Module> modules = new ArrayList<>();
        modules.add(new DetectModule());

        return modules;
    }
}

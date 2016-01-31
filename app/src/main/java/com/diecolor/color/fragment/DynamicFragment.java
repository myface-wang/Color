package com.diecolor.color.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.diecolor.color.R;
import com.diecolor.color.adapter.Dynamicadapter;

/**
 * Created by Administrator on 2016/1/18.
 */
public class DynamicFragment extends Fragment{

    private View rootview;

    private SwipeRefreshLayout swipe_dynamic;
    private ListView list_dynamic;

    private Dynamicadapter dynamicadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_dynamic, null);

        initview();
        return rootview;
    }

    private void initview() {
        swipe_dynamic= (SwipeRefreshLayout) rootview.findViewById(R.id.swipe_dynamic);
        list_dynamic= (ListView) rootview.findViewById(R.id.list_dynamic);

        Context context= getActivity();
        dynamicadapter=new Dynamicadapter(context);
        list_dynamic.setAdapter(dynamicadapter);

    }
}

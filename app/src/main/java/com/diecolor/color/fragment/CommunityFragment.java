package com.diecolor.color.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diecolor.color.R;
import com.diecolor.color.adapter.CommunityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/18.
 */
public class CommunityFragment extends Fragment{

    private View rootview;

    private ViewPager viewpager_code;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_community, null);

        initview();

        return rootview;
    }

    private void initview() {
        TabLayout tab= (TabLayout) rootview.findViewById(R.id.tab_code);

        viewpager_code= (ViewPager) rootview.findViewById(R.id.viewpager_code);

        List<String> titles=new ArrayList<>();
        titles.add(0,"动态");
        titles.add(1,"广场");

        List<Fragment> fragments=new ArrayList<>();

        tab.addTab(tab.newTab().setText(titles.get(0)));
        Fragment fragmentme=new DynamicFragment();
        fragments.add(fragmentme);

        tab.addTab(tab.newTab().setText(titles.get(0)));
        Fragment fragmentus=new SquareFragment();
        fragments.add(fragmentus);


        CommunityAdapter adapter=new CommunityAdapter(getActivity().getSupportFragmentManager(),fragments, titles);
        viewpager_code.setAdapter(adapter);
        tab.setupWithViewPager(viewpager_code);
        tab.setTabsFromPagerAdapter(adapter);
    }
}

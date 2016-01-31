package com.diecolor.color.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.diecolor.color.R;
import com.diecolor.color.View.rollviewpager.RollPagerView;
import com.diecolor.color.adapter.BannerAdapter;
import com.diecolor.color.adapter.SquareAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/18.
 */
public class SquareFragment extends Fragment{

    private View rootview;
    private View banner;

    private SwipeRefreshLayout swipe_square;
    private ListView list_dynamic;

    private SquareAdapter squareAdapter;
    private RollPagerView mRollViewPager;
    private BannerAdapter bannerAdapter;

    private ArrayList<String> bannerBeans=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_square, null);


        initview();
        return rootview;
    }

    private void initview() {
        swipe_square= (SwipeRefreshLayout) rootview.findViewById(R.id.swipe_square);
        list_dynamic= (ListView) rootview.findViewById(R.id.list_square);


        banner = getActivity().getLayoutInflater().inflate(R.layout.headview_banner, null);



        bannerBeans.add(0, "1");
        bannerBeans.add(0,"2");
        bannerBeans.add(0, "3");

        mRollViewPager= (RollPagerView) banner.findViewById(R.id.roll_view_pager);
        mRollViewPager.setAnimationDurtion(1000);
        bannerAdapter=new BannerAdapter(bannerBeans,getActivity());
        mRollViewPager.setAdapter(bannerAdapter);
        mRollViewPager.setSwipeRefreshLayout(swipe_square);  //控制SwipeRefreshLayout与viewpager的滑动冲突


        swipe_square.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorPrimaryDark,
                R.color.colorPrimary,
                R.color.colorPrimaryDark);


        swipe_square.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

//                refresh();

            }
        });

        list_dynamic.addHeaderView(banner);

        squareAdapter=new SquareAdapter(getActivity());
        list_dynamic.setAdapter(squareAdapter);
    }
}

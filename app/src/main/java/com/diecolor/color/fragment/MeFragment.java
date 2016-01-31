package com.diecolor.color.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.diecolor.color.R;

/**
 * Created by Administrator on 2016/1/18.
 */
public class MeFragment extends Fragment{

    private View rootview;
    private ScrollView scroll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_me, null);

        initview();
        return rootview;
    }

    private void initview() {
        scroll= (ScrollView) rootview.findViewById(R.id.scroll);

        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    // 可以监听到ScrollView的滚动事件
//                    if (scroll.getScrollY()>=170)
//                    {
//                       String H= Integer.toHexString(scroll.getScrollY());
//                        System.out.println(H);
//                    }
//                    System.out.println(scroll.getScrollY());
                }

                return false;
            }
        });

    }
}

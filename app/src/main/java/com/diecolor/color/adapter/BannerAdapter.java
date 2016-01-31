package com.diecolor.color.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.diecolor.color.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/12/24.
 */
public class BannerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<String> bannerBeans;

    public BannerAdapter(ArrayList<String> bannerBeans, Context context)
    {
        this.bannerBeans=bannerBeans;
        this.context=context;
    }

    @Override
    public int getCount() {
        return bannerBeans.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = getView(container,position);
        container.addView(itemView);
        return itemView;
    }

    public View getView(ViewGroup container, final int position) {
        ImageView view = new ImageView(container.getContext());

        bannerBeans.get(position);
        int i= position%bannerBeans.size();

        if (i==1)
        {
            view.setImageResource(R.drawable.banner);
        }else {
            view.setImageResource(R.drawable.item_dy);
        }

        view.setScaleType(ImageView.ScaleType.CENTER_CROP);

        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

}

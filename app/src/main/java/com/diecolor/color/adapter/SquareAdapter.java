package com.diecolor.color.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.diecolor.color.R;

/**
 * Created by Administrator on 2016/1/18.
 */
public class SquareAdapter extends BaseAdapter{

    private Context context;
    private LayoutInflater layoutInflater;

    public SquareAdapter(Context context){
        this.context=context;
        layoutInflater= LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_square, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    static class ViewHolder {

    }
}

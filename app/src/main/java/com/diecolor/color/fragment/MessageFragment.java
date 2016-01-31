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
import com.diecolor.color.adapter.MessageAdapter;

/**
 * Created by Administrator on 2016/1/18.
 */
public class MessageFragment extends Fragment{

    private View rootview;

    private SwipeRefreshLayout swipe_message;
    private ListView list_message;

    private MessageAdapter messageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_message, null);

        initview();
        return rootview;
    }

    private void initview() {
        swipe_message= (SwipeRefreshLayout) rootview.findViewById(R.id.swipe_message);
        list_message= (ListView) rootview.findViewById(R.id.list_message);

        Context context= getActivity();
        messageAdapter=new MessageAdapter(context);
        list_message.setAdapter(messageAdapter);


    }


}

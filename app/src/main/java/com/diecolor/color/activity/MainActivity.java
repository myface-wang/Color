package com.diecolor.color.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.diecolor.color.R;
import com.diecolor.color.fragment.CommunityFragment;
import com.diecolor.color.fragment.DiscoveryFragment;
import com.diecolor.color.fragment.MeFragment;
import com.diecolor.color.fragment.MessageFragment;
import com.diecolor.color.fragment.SportFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CommunityFragment communityFragment;
    private DiscoveryFragment discoveryFragment;
    private MeFragment meFragment;
    private MessageFragment messageFragment;
    private SportFragment sportFragment;

    private FrameLayout fl_content;

    private LinearLayout ll_community,ll_discovery,ll_sport,ll_message,ll_me;

    private ImageView img_community,img_discovery,img_sport,img_message,img_me;

    private TextView tv_community,tv_discovery,tv_sport,tv_message,tv_me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initview();
        setSelect(0);

    }

    private void initview() {
        fl_content= (FrameLayout) findViewById(R.id.fl_content);

        ll_community= (LinearLayout) findViewById(R.id.ll_community);
        ll_discovery= (LinearLayout) findViewById(R.id.ll_discovery);
        ll_sport= (LinearLayout) findViewById(R.id.ll_sport);
        ll_message= (LinearLayout) findViewById(R.id.ll_message);
        ll_me= (LinearLayout) findViewById(R.id.ll_me);
        ll_community.setOnClickListener(this);
        ll_discovery.setOnClickListener(this);
        ll_sport.setOnClickListener(this);
        ll_message.setOnClickListener(this);
        ll_me.setOnClickListener(this);


        img_community= (ImageView) findViewById(R.id.img_community);
        img_discovery= (ImageView) findViewById(R.id.img_discovery);
        img_sport= (ImageView) findViewById(R.id.img_sport);
        img_message= (ImageView) findViewById(R.id.img_message);
        img_me= (ImageView) findViewById(R.id.img_me);

        tv_community= (TextView) findViewById(R.id.tv_community);
        tv_discovery= (TextView) findViewById(R.id.tv_discovery);
        tv_sport= (TextView) findViewById(R.id.tv_sport);
        tv_message= (TextView) findViewById(R.id.tv_message);
        tv_me= (TextView) findViewById(R.id.tv_me);

    }


    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        Bundle bundle = null;
        switch (i) {
            case 0:
                if (communityFragment == null) {
                    communityFragment = new CommunityFragment();
                    transaction.add(R.id.fl_content, communityFragment, "home");
                } else {
                    transaction.show(communityFragment);
                }
                img_community.setImageResource(R.drawable.main_tab_social_selected);
                tv_community.setTextColor(Color.parseColor("#6CBB52"));
                break;
            case 1:

                if (discoveryFragment == null) {
                    discoveryFragment = new DiscoveryFragment();
//                    bundle = new Bundle();
//                    bundle.putString(DiscoverFragment.TITLE, mTitles[1]);
//                    mTab02.setArguments(bundle);
                    transaction.add(R.id.fl_content, discoveryFragment, "discover");
                } else {
                    transaction.show(discoveryFragment);
                }
                img_discovery.setImageResource(R.drawable.ic_tab_dis_selected);
                tv_discovery.setTextColor(Color.parseColor("#6CBB52"));
                break;
            case 2:
                if (sportFragment == null) {
                    sportFragment = new SportFragment();
//                    bundle = new Bundle();
//                    bundle.putString(FavoriteFragment.TITLE, mTitles[2]);
//                    mTab03.setArguments(bundle);
                    transaction.add(R.id.fl_content, sportFragment, "favorite");
                } else {
                    transaction.show(sportFragment);

                }
                img_sport.setImageResource(R.drawable.ic_tab_sport_selected);
                tv_sport.setTextColor(Color.parseColor("#6CBB52"));
                break;
            case 3:
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
//                    bundle = new Bundle();
//                    bundle.putString(TabFragment.TITLE, mTitles[3]);
//                    mTab04.setArguments(bundle);
                    transaction.add(R.id.fl_content, messageFragment, "mine");
                } else {
                    transaction.show(messageFragment);
                }
                img_message.setImageResource(R.drawable.ic_tab_msg_selected);
                tv_message.setTextColor(Color.parseColor("#6CBB52"));
                break;
            case 4:
                if (meFragment == null) {
                    meFragment = new MeFragment();
//                    bundle = new Bundle();
//                    bundle.putString(TabFragment.TITLE, mTitles[3]);
//                    mTab04.setArguments(bundle);
                    transaction.add(R.id.fl_content, meFragment, "mine");
                } else {
                    transaction.show(meFragment);
                }
                img_me.setImageResource(R.drawable.ic_tab_me_selected);
                tv_me.setTextColor(Color.parseColor("#6CBB52"));
                break;
            default:
                break;
        }

        transaction.commit();
    }


    public void hideFragment(FragmentTransaction transaction) {
        if (communityFragment != null) {
            transaction.hide(communityFragment);
        }
        if (discoveryFragment != null) {
            transaction.hide(discoveryFragment);
        }
        if (sportFragment != null) {
            transaction.hide(sportFragment);
        }
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
    }

    @Override
    public void onClick(View v) {
        resetImgs();
        resetText();
        switch (v.getId())
        {
            case R.id.ll_community:
                setSelect(0);
                break;
            case R.id.ll_discovery:
                setSelect(1);
                break;
            case R.id.ll_sport:
                setSelect(2);
                break;
            case R.id.ll_message:
                setSelect(3);
                break;
            case R.id.ll_me:
                setSelect(4);
                break;
            default:
//                setSelect(index);
                break;

        }
    }

    private void resetImgs() {
        img_community.setImageResource(R.drawable.main_tab_social_normal);
        img_discovery.setImageResource(R.drawable.ic_tab_dis_normal);
        img_sport.setImageResource(R.drawable.ic_tab_sport_normal);
        img_message.setImageResource(R.drawable.ic_tab_msg_normal);
        img_me.setImageResource(R.drawable.ic_tab_me_normal);
    }

    private void resetText(){
        tv_community.setTextColor(Color.parseColor("#ADADAD"));
        tv_discovery.setTextColor(Color.parseColor("#ADADAD"));
        tv_sport.setTextColor(Color.parseColor("#ADADAD"));
        tv_message.setTextColor(Color.parseColor("#ADADAD"));
        tv_me.setTextColor(Color.parseColor("#ADADAD"));
    }

}

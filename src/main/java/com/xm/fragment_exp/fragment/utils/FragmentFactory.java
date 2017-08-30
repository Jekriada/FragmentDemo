package com.xm.fragment_exp.fragment.utils;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xm.fragment_exp.fragment.IndexFragment;
import com.xm.fragment_exp.fragment.MyFragment;
import com.xm.fragment_exp.fragment.NearByFragment;
import com.xm.fragment_exp.fragment.StrollFragment;
import com.xm.fragment_exp.fragment.index.FoodFragment;
import com.xm.fragment_exp.fragment.index.HandpickFragment;
import com.xm.fragment_exp.fragment.index.MovieFragment;
import com.xm.fragment_exp.fragment.index.TripFragment;

public class FragmentFactory {
    public static final int FRAGMENT_INDEX = 0; //首页
    public static final int FRAGMENT_NEARBY = 1; //附近
    public static final int FRAGMENT_STROLL = 2; //逛逛
    public static final int FRAGMENT_MY = 3; //我的

    //创建一个Map，fragment中放在集合中，第一个参数是脚标，第二个是fRAGMENT  
    private static Map<Integer, Fragment> mFragments = new HashMap<Integer, Fragment>();

    public static Fragment createFragment(int position) {
        Fragment fragment = null;
        //在集合中取出来Fragment  
        fragment = mFragments.get(position);
        //如果再集合中没有取出来 需要重新创建
        switch (position) {
            case FRAGMENT_INDEX:
                fragment = new IndexFragment();
                break;
            case FRAGMENT_NEARBY:
                fragment = new NearByFragment();
                break;
            case FRAGMENT_STROLL:
                fragment = new StrollFragment();
                break;
            case FRAGMENT_MY:
                fragment = new MyFragment();
                break;
        }

        //保存fragment
        if (fragment != null) {
            mFragments.put(position, fragment);// 把创建好的Fragment存放到集合中缓存起来
        }

        return fragment;
    }

    private static ArrayList<Fragment> fragments;

    /**
     *创建主界面Fragment列表
     */
    public static ArrayList<Fragment> createMainFragments() {
        fragments = new ArrayList<>();
        fragments.add(new IndexFragment());
        fragments.add(new NearByFragment());
        fragments.add(new StrollFragment());
        fragments.add(new MyFragment());
        return fragments;
    }
    /**
     *创建首页子Fragment列表
     */
    public static ArrayList<Fragment> createIndexFragments() {
        fragments = new ArrayList<>();
        fragments.add(new HandpickFragment());
        fragments.add(new FoodFragment());
        fragments.add(new TripFragment());
        fragments.add(new MovieFragment());
        return fragments;
    }
}  
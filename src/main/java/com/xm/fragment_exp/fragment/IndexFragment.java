package com.xm.fragment_exp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xm.fragment_exp.R;
import com.xm.fragment_exp.fragment.utils.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.xm.fragment_exp.TestFragmentAdapter;

public class IndexFragment extends Fragment {


    @BindView(R.id.sliding_tabs)
    TabLayout mSlidingTabs;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private List<Fragment> mList = new ArrayList<Fragment>();
    private TestFragmentAdapter mTestFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragment_sc, null);
        initView(view);

        return view;
    }

    /**
     * 初始化控件
     *
     * @param view
     */
    private void initView(View view) {

        ButterKnife.bind(this, view);

        initPager();
    }

    /**
     * 设置子Fragment数据
     */
    private void initPager() {
        String tabTitles[] = new String[]{"精选", "美食", "游玩", "电影"};

        //获取子fragment列表
        mList = FragmentFactory.createIndexFragments();
        /**
         *  创建FragmentAdapter
         *  这里因为Fragment里面嵌套Fragment ,需要使用getChildFragmentManager()来管理,
         *  不然会出现一些异常
         */
        mTestFragmentAdapter = new TestFragmentAdapter(getChildFragmentManager(),
                tabTitles, mList);
        //绑定FragmentAdapter
        mViewpager.setAdapter(mTestFragmentAdapter);
        //绑定ViewPager
        mSlidingTabs.setupWithViewPager(mViewpager);
        //设置TabLayout模式
        mSlidingTabs.setTabMode(TabLayout.MODE_FIXED);
    }


}
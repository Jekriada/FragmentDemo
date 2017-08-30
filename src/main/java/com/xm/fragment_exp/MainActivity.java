package com.xm.fragment_exp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.xm.fragment_exp.fragment.utils.FragmentFactory;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.sliding_tabs)
    TabLayout mSlidingTabs;

    private List<Fragment> mList = new ArrayList<Fragment>();
    private TestFragmentAdapter mTestFragmentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        ButterKnife.bind(this);

        initData();
    }

    /**
     * 数据绑定,页面显示
     */
    private void initData() {
        String tabTitles[] = new String[]{"首页", "附近", "逛逛","我的"};

        //获取fragment集合
        mList = FragmentFactory.createMainFragments();

        //构造TestFragmentAdapter
        mTestFragmentAdapter = new TestFragmentAdapter(getSupportFragmentManager(),
                tabTitles,mList);

        //绑定Adapter
        mViewpager.setAdapter(mTestFragmentAdapter);

        //绑定ViewPager
        mSlidingTabs.setupWithViewPager(mViewpager);
        //设置TabLayout模式
        mSlidingTabs.setTabMode(TabLayout.MODE_FIXED);
    }


}

package com.dzs.cloudmusic.view.nativeview.main.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.dzs.cloudmusic.R;
import com.dzs.cloudmusic.common.mvp.BaseFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * Created by dzs on 2016/9/8.
 */
public abstract class ViewPagerFragment extends BaseFragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    FragmentPagerItems pages;

    FragmentPagerItemAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_viewpager;
    }
    @Override
    protected void initView() {
        tabLayout = (TabLayout) rootView.findViewById(R.id.mTabLayout);
        viewPager = (ViewPager) rootView.findViewById(R.id.mViewPager);
        initFragments();
        setup();
    }


    protected abstract void initFragments();

    private void setup() {
        adapter = new FragmentPagerItemAdapter(
                getChildFragmentManager(), pages);
        viewPager.setAdapter(adapter);
        tabLayout.setTabTextColors(getResources().getColor(R.color.tabTextNormalColor),getResources().getColor(R.color.theme_color_Primary));
        tabLayout.setupWithViewPager(viewPager,true);
    }
}

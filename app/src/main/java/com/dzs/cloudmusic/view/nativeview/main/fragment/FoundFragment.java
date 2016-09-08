package com.dzs.cloudmusic.view.nativeview.main.fragment;


import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * Created by dzs on 2016/9/8.
 */
public class FoundFragment extends ViewPagerFragment {
    @Override
    protected void initFragments() {
        pages = new FragmentPagerItems(getContext());
        pages.add(FragmentPagerItem.of("个性推荐", MusicFragment.class));
        pages.add(FragmentPagerItem.of("歌单", MusicFragment.class));
        pages.add(FragmentPagerItem.of("主播电台", MusicFragment.class));
        pages.add(FragmentPagerItem.of("排行榜", MusicFragment.class));

    }
}

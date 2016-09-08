package com.dzs.cloudmusic.view.nativeview.main.fragment;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * Created by dzs on 2016/9/8.
 */
public class FriendFragment extends ViewPagerFragment {
    @Override
    protected void initFragments() {
        pages = new FragmentPagerItems(getContext());
        pages.add(FragmentPagerItem.of("动态", MusicFragment.class));
        pages.add(FragmentPagerItem.of("附近", MusicFragment.class));
        pages.add(FragmentPagerItem.of("好友", MusicFragment.class));
    }
}

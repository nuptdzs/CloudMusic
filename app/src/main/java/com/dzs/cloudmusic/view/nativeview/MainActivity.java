package com.dzs.cloudmusic.view.nativeview;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.dzs.cloudmusic.R;
import com.dzs.cloudmusic.common.mvp.BaseActivity;
import com.dzs.cloudmusic.common.mvp.CommonAdapter;
import com.dzs.cloudmusic.contract.MainContract;
import com.dzs.cloudmusic.model.MenuItemBean;
import com.dzs.cloudmusic.model.UserBean;
import com.dzs.cloudmusic.presenter.MainPresenter;
import com.dzs.cloudmusic.view.nativeview.main.MenuHeaderView;
import com.dzs.cloudmusic.view.nativeview.main.MenuItemView;
import com.dzs.cloudmusic.view.nativeview.main.fragment.FoundFragment;
import com.dzs.cloudmusic.view.nativeview.main.fragment.FriendFragment;
import com.dzs.cloudmusic.view.nativeview.main.fragment.MusicFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IMainView {

   /* @BindView(R.id.mainDrawerIcon)
    ImageView mainDrawerIcon;*/
    @BindView(R.id.mainActivityViewPager)
    ViewPager mainActivityViewPager;
    @BindView(R.id.mainActivityViewPagerContainer)
    FrameLayout mainActivityViewPagerContainer;
    @BindView(R.id.mainDrawer)
    DrawerLayout mainDrawer;
    @BindView(R.id.content)
    LinearLayout content;
    @BindView(R.id.drawerView)
    View drawerView;
    @BindView(R.id.DrawerListView)
    ListView DrawerListView;
    @BindView(R.id.drawerSetting)
    TextView drawerSetting;
    @BindView(R.id.drawerQuit)
    TextView drawerQuit;
    @BindView(R.id.drawerBottomContainer)
    LinearLayout drawerBottomContainer;
    @BindView(R.id.viewpagertab)
    SmartTabLayout viewpagertab;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return null;
    }

    @Override
    protected void addEvent() {
        setCommonActionBar(null);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationIcon(R.drawable.actionbar_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDrawer.openDrawer(Gravity.LEFT);

            }
        });


    }

    @Override
    protected void loadData() {
        MenuHeaderView menuHeaderView = new MenuHeaderView(this);
        UserBean userBean = new UserBean();
        userBean.setUserNickName("水煮大冬瓜");
        userBean.setAvatarUrl("http://pic.qiantucdn.com/58pic/16/69/20/20Y58PICqzS_1024.jpg");
        userBean.setBgUrl("http://pic.qiantucdn.com/58pic/16/69/20/20Y58PICqzS_1024.jpg");
        userBean.setLevel(5);
        menuHeaderView.setData(userBean);
        DrawerListView.addHeaderView(menuHeaderView);
        DrawerListView.setAdapter(new CommonAdapter<>(MenuItemBean.getDefaultMenuList(), new MenuItemView(this)));
        createTabs();
    }

    private void createTabs() {
        viewpagertab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                ImageView icon = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab_icon, container,
                        false);
                switch (position) {
                    case 1:
                        icon.setImageResource(R.drawable.actionbar_music_selected);
                        break;
                    case 0:
                        icon.setImageResource(R.drawable.actionbar_discover_selected);
                        break;
                    case 2:
                        icon.setImageResource(R.drawable.actionbar_friends_selected);
                        break;

                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }
                return icon;
            }
        });
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of("发现", FoundFragment.class));
        pages.add(FragmentPagerItem.of("音乐", MusicFragment.class));
        pages.add(FragmentPagerItem.of("朋友", FriendFragment.class));
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);

        mainActivityViewPager.setAdapter(adapter);
        viewpagertab.setViewPager(mainActivityViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
            menu.findItem(R.id.search_menu).setVisible(true);
        return super.onPrepareOptionsMenu(menu);
    }
}

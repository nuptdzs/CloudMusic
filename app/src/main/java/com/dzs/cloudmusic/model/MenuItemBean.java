package com.dzs.cloudmusic.model;


import com.dzs.cloudmusic.R;
import com.dzs.cloudmusic.common.mvp.BaseActivity;
import com.dzs.cloudmusic.view.nativeview.MessageActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzs on 2016/9/7.
 */
public class MenuItemBean {
    int iconResId;
    String title;
    String hint;
    Class<? extends BaseActivity> target;

    public MenuItemBean(int iconResId, String title, String hint, Class<? extends BaseActivity> target) {
        this.iconResId = iconResId;
        this.title = title;
        this.hint = hint;
        this.target = target;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Class<? extends BaseActivity> getTarget() {
        return target;
    }

    public void setTarget(Class<? extends BaseActivity> target) {
        this.target = target;
    }

    public static List<MenuItemBean> getDefaultMenuList(){
        List<MenuItemBean> itemBeens = new ArrayList<>();
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_msg,"我的消息",null, MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_store,"积分商城","12积分",MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_vip,"会员中心",null,MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_free,"在线免流量听歌",null,MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_identify,"听歌识曲",null,MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_skin,"主题换肤","skin",MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_night,"夜间模式",null,MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_vip,"定时停止播放",null,MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_clock,"音乐闹钟",null,MessageActivity.class));
        itemBeens.add(new MenuItemBean(R.drawable.topmenu_icn_cloud,"我的音乐云盘",null,MessageActivity.class));
        return itemBeens;
    }
}

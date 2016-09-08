package com.dzs.cloudmusic.view.nativeview.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dzs.cloudmusic.R;
import com.dzs.cloudmusic.model.UserBean;
import com.meg7.widget.CircleImageView;


/**
 * Created by dzs on 2016/9/7.
 */
public class MenuHeaderView extends RelativeLayout {

    CircleImageView imgAvatar;
    TextView tvUserName;
    TextView drawerUserLevel;
    TextView drawerUserSignIn;
    ImageView imgBg;

    private View rootView;

    public MenuHeaderView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.menu_header, this);
        imgBg = (ImageView) rootView.findViewById(R.id.imgBg);
        tvUserName = (TextView) rootView.findViewById(R.id.tvUserName);
        drawerUserLevel = (TextView) rootView.findViewById(R.id.drawerUserLevel);
        imgAvatar = (CircleImageView) rootView.findViewById(R.id.imgAvatar);
    }

    public View getView(){
        return rootView;
    }
    public void setData(UserBean userBean) {
        tvUserName.setText(userBean.getUserNickName());
        drawerUserLevel.setText("Lv."+userBean.getLevel());
        Glide.with(getContext()).load(userBean.getBgUrl()).into(imgBg);

        Glide.with(getContext()).load(userBean.getAvatarUrl()).into(imgAvatar);
    }
}

package com.dzs.cloudmusic.view.nativeview.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.dzs.cloudmusic.R;
import com.dzs.cloudmusic.common.mvp.BaseViewHolder;
import com.dzs.cloudmusic.model.MenuItemBean;


/**
 * Created by dzs on 2016/9/7.
 */
public class MenuItemView extends BaseViewHolder<MenuItemBean> {


    ImageView imgIcon;
    TextView tvTitle;
    TextView tvHint;
    Switch sw;

    public MenuItemView(Context context) {
        super(context);
    }

    @Override
    public void initview() {
        if (rootView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.topmenu_item, null);
            imgIcon = (ImageView) rootView.findViewById(R.id.imgIcon);
            tvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
            tvHint = (TextView) rootView.findViewById(R.id.tvHint);
            sw = (Switch) rootView.findViewById(R.id.sw);
        }
    }

    @Override
    public void setData(final MenuItemBean menuItemBean) {
        imgIcon.setImageResource(menuItemBean.getIconResId());
        tvTitle.setText(menuItemBean.getTitle());
        sw.setVisibility(View.GONE);
        tvHint.setVisibility(View.GONE);
        if(menuItemBean.getHint() == null){

        }else if (menuItemBean.getHint().equals("skin")){
            sw.setVisibility(View.VISIBLE);
        }else {
            tvHint.setVisibility(View.VISIBLE);
            tvHint.setText(menuItemBean.getHint());
        }
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),menuItemBean.getTarget());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public BaseViewHolder<MenuItemBean> getInstance() {
        return new MenuItemView(getContext());
    }
}

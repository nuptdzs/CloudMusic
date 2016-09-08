package com.dzs.cloudmusic.view.nativeview;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dzs.cloudmusic.R;
import com.dzs.cloudmusic.common.mvp.BaseActivity;
import com.dzs.cloudmusic.common.mvp.BasePresenter;



public class MessageActivity extends BaseActivity {




    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void addEvent() {
        setCommonActionBar("消息");
    }

    @Override
    protected void loadData() {

    }
}

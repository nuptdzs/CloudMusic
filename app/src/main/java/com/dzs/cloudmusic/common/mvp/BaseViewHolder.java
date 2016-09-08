package com.dzs.cloudmusic.common.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by dzs on 2016/7/8.
 */
public abstract class BaseViewHolder<Model>{

    protected View rootView;

    public Context getContext() {
        return mContext;
    }

    public View getRootView() {
        return rootView;
    }

    protected Context mContext;
    public BaseViewHolder(Context context) {
        mContext = context;
    }

    protected void setRootView(int rootViewResId){
        if(rootView == null){
            rootView = LayoutInflater.from(getContext()).inflate(rootViewResId,null);
            ButterKnife.bind(rootView);

        }
    }
    public abstract void initview();

    public abstract void setData(Model model);
    public abstract BaseViewHolder<Model> getInstance();
}

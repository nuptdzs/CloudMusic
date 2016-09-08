package com.dzs.cloudmusic.common.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by dzs on 2016/9/8.
 */
public abstract class BaseFragment extends Fragment {

    protected View rootView;
    protected BaseActivity mActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate(getLayout(),container,false);
            ButterKnife.bind(rootView);
            initView();
        }
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(getActivity() instanceof BaseActivity){
            mActivity = (BaseActivity) getActivity();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    protected abstract int getLayout();

    protected abstract void initView();

}

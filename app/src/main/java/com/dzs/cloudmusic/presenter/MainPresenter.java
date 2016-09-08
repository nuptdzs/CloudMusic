package com.dzs.cloudmusic.presenter;

import com.dzs.cloudmusic.common.mvp.BasePresenter;
import com.dzs.cloudmusic.contract.MainContract;

/**
 * Created by dzs on 2016/9/7.
 */
public class MainPresenter extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter{

    /**
     * 创建presenter的时候加载view
     *
     * @param view
     */
    public MainPresenter(MainContract.IMainView view) {
        super(view);
    }
}

package com.dzs.cloudmusic.common.network;

/**
 * Created by dzs on 2016/7/11.
 */
public interface ICallBack<T> {
    void onSuccess(T t);
    void onFailure(int code, String err_msg);
}

package com.dzs.cloudmusic.common.network;

import java.util.HashSet;
import java.util.Set;

import rx.Observer;

/**
 * Created by dzs on 2016/8/22.
 */
public abstract class HttpReuslObs<T> implements Observer<T> {

    private static final int NETWORK_NOT_RESPONDING = 133;
    private static final int ERROR_RESULT_IS_NULL = 122;

    public HttpReuslObs(){
        for(String resultTag :resultTags){
            resultTagsSet.add(resultTag);
        }
        for (String resultValue :resultTagsSet){
            resultValuesSet.add(resultValue);
        }
    }
    @Override
    public void onCompleted() {

    }


    @Override
    public void onError(Throwable e) {
        onFailure("网络连接失败",NETWORK_NOT_RESPONDING);
    }

    Set<String> resultTagsSet = new HashSet<>();
    Set<String> resultValuesSet = new HashSet<>();
    String[] resultTags = {};
    String[] resultValues = {};
    @Override
    public void onNext(T t){
        boolean isSuccess = true;
        if(t == null){
            onFailure("结果为空",ERROR_RESULT_IS_NULL);
            return;
        }
        /*Field[] fields = t.getClass().getFields();
        for(Field field :fields){
            String name  = field.getName();
            if(resultTagsSet.contains(name)){
                try {
                    String result = (String) field.get(t);
                    if(resultValuesSet.contains(result)){
                        isSuccess = true;
                    }else {
                        isSuccess = false;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }*/
        if(isSuccess){
            onSuccess(t);
        }else {
            onFailure("操作失败",201);
        }
    }

    public abstract void onFailure(String errorMsg, int errorCode);
    public abstract void onSuccess(T t);
}

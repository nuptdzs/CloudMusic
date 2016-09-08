package com.dzs.cloudmusic.common.mvp;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dzs on 2016/9/5.
 */
public class MyAdapter<MODEL> extends RecyclerView.Adapter<BaseHolder<MODEL>> {

    private List<MODEL> modelList;
    private BaseHolder<MODEL> holder;
    public MyAdapter(List<MODEL> models, BaseHolder<MODEL> holder){
        this.modelList = models;
        this.holder = holder;
    }

    @Override
    public BaseHolder<MODEL> onCreateViewHolder(ViewGroup parent, int viewType) {
        return holder.getInstance();
    }

    @Override
    public void onBindViewHolder(BaseHolder<MODEL> holder, int position) {
        holder.initdata(modelList.get(position));
    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }

}

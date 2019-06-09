package com.chris.widget.sample.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chris.widget.R;

import java.util.List;

/**
 * create by Chris Chan
 * create on 2019/6/9 11:16
 * use for :
 */
public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private Context context;
    private List<MainItem> dataList;

    public MainAdapter(List<MainItem> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(this.context).inflate(R.layout.itm_main, null);
        return new MainViewHolder(this.context, view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.refreshView(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

package com.chris.widget.sample.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chris.widget.R;

/**
 * create by Chris Chan
 * create on 2019/6/9 11:18
 * use for :
 */
public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Context context;
    private View itemView;
    private MainItem item;

    private ImageView ivImg;
    private TextView tvTitle;

    public MainViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        this.itemView = itemView;

        ivImg = itemView.findViewById(R.id.iv_main_item_img);
        tvTitle = itemView.findViewById(R.id.tv_main_item_title);

        itemView.setOnClickListener(this);
    }

    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }

    public void refreshView(MainItem item) {
        this.item = item;
        if (null != item.getImageResId()) {
            Glide.with(context).load(item.getImageResId()).into(ivImg);
        } else {
            Glide.with(context).load(item.getImageUrl()).into(ivImg);
        }
        tvTitle.setText(item.getTitle());
    }

    @Override
    public void onClick(View view) {
        context.startActivity(new Intent(context, item.getTargetClass()));
    }
}

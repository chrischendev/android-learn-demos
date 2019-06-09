package com.chris.widget.sample.main;

import android.support.annotation.DrawableRes;

/**
 * create by Chris Chan
 * create on 2019/6/9 11:22
 * use for :
 */
public class MainItem {
    private String title;
    private String imageUrl;
    private @DrawableRes
    Integer imageResId;
    private Class<?> targetClass;

    public MainItem() {
    }

    public MainItem(String title, Integer imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public MainItem(String title, String imageUrl, Class<?> targetClass) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.targetClass = targetClass;
    }

    public MainItem(String title, Integer imageResId, Class<?> targetClass) {
        this.title = title;
        this.imageResId = imageResId;
        this.targetClass = targetClass;
    }

    public MainItem(String title, String imageUrl, Integer imageResId, Class<?> targetClass) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.imageResId = imageResId;
        this.targetClass = targetClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getImageResId() {
        return imageResId;
    }

    public void setImageResId(Integer imageResId) {
        this.imageResId = imageResId;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }
}

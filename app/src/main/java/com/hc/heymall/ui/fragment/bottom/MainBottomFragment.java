package com.hc.heymall.ui.fragment.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.hc.heymall.model.BottomItemFragment;
import com.hc.heymall.model.BottomTabBean;
import com.hc.heymall.model.ItemBuilder;
import com.hc.heymall.ui.fragment.home.IndexFragment;

import java.util.LinkedHashMap;


public class MainBottomFragment extends BaseBottomFragment {


    @Override
    public LinkedHashMap<BottomTabBean, BottomItemFragment> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemFragment> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{icon-weixintwo}", "主页"), new IndexFragment());
        items.put(new BottomTabBean("{icon-weixintwo}", "分类"), new IndexFragment());
        items.put(new BottomTabBean("{icon-weixintwo}", "发现"), new IndexFragment());
        items.put(new BottomTabBean("{icon-weixintwo}", "购物车"), new IndexFragment());
        items.put(new BottomTabBean("{icon-weixintwo}", "我的"), new IndexFragment());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexFragment() {
        return 0;
    }

    @Override
    public int setClickColor() {
        return Color.parseColor("#ffff8800");
    }

    @Override
    public int initLayout() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}

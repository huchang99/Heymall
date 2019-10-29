package com.hc.homecenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.hc.homecenter.R;
import com.hc.homecenter.model.MenuBean;

import java.util.ArrayList;
import java.util.List;

public class HomeGridViewAdapter extends BaseAdapter {

    private List<MenuBean> dataList = new ArrayList<>();
    private Context mContext;


    public HomeGridViewAdapter(Context mContext, List<MenuBean> menuList, int page, int item_grid_num) {
        this.mContext = mContext;
        // this.menuList = menuList;
        //start end分别代表要显示的数组在总数据List中的开始和结束位置
        int start = page * item_grid_num;
        int end = start + item_grid_num;
        while ((start < menuList.size()) && (start < end)) {
            dataList.add(menuList.get(start));
            start++;
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null) {
            mHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_gridview, null);
            mHolder.iv_img = (ImageView) convertView.findViewById(R.id.iv_img);
            mHolder.tv_text = (TextView) convertView.findViewById(R.id.tv_text);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        MenuBean bean = dataList.get(position);
        if (bean != null) {
            mHolder.iv_img.setImageResource(R.drawable.ic_share_pyq);
            mHolder.tv_text.setText(bean.name);
        }
        return convertView;
    }

    private class ViewHolder {
        private ImageView iv_img;
        private TextView tv_text;

    }
}




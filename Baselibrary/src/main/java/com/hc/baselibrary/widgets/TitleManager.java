package com.hc.baselibrary.widgets;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hc.baselibrary.R;
import com.hc.baselibrary.ui.activity.BaseActivity;

public class TitleManager implements View.OnClickListener {

    private FrameLayout titleBar;
    private BaseActivity mActivity;
    private TextView title_name;

    public TitleManager(BaseActivity activity, int layoutId) {
        super();
        mActivity = activity;
        titleBar = (FrameLayout) activity.findViewById(layoutId);
    }

    public TitleManager(BaseActivity activity, int layoutId, View frameview) {
        super();
        mActivity = activity;
        titleBar = (FrameLayout) frameview.findViewById(layoutId);
    }

    public TitleManager(BaseActivity activity, View layout) {
        super();
        // TODO Auto-generated constructor stub
        mActivity = activity;
        titleBar = (FrameLayout) layout;

    }

    public void setTitleBackGround(int resId) {
        try {
            if (titleBar != null) {
                titleBar.setBackgroundResource(resId);
            }
        } catch (Exception e) {

        }
    }

    private void init() {
        title_name = (TextView) titleBar.findViewById(R.id.title_name);

    }


    public void setTitleName(String name) {
        if (title_name != null) {
            if (name.length() > 15) {
                title_name.setText(name.substring(0, 14) + "...");
            } else {
                title_name.setText(name);
            }
        } else {
            //title_name.setText("");
        }
    }

    /**
     * 设置标题栏布局
     *
     * @param layoutResID
     */
    public void setTitleBar(int layoutResID) {
        if (layoutResID == 0) {
            titleBar.removeAllViews();
        } else {
            titleBar.removeAllViews();
            LayoutInflater.from(mActivity).inflate(layoutResID, titleBar);
        }
        init();
    }

    /**
     * 显示标题栏
     */
    public void showTitleBar() {
        titleBar.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏标题栏
     */
    public void hideTitleBar() {
        titleBar.setVisibility(View.GONE);
    }

    /**
     * 移除标题栏
     */
    public void removeTitleBarView() {
        titleBar.removeAllViews();
        titleBar.setVisibility(View.GONE);
    }

    /**
     * 获取activity标题栏
     *
     * @return
     */
    public ViewGroup getTitleBar() {
        return titleBar;
    }

    @Override
    public void onClick(View v) {

    }
}

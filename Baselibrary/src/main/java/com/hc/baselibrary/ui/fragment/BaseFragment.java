package com.hc.baselibrary.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.hc.baselibrary.R;
import com.hc.baselibrary.ui.activity.BaseActivity;
import com.hc.baselibrary.ui.activity.ViewInit;
import com.hc.baselibrary.widgets.TitleManager;

public abstract class BaseFragment extends Fragment implements ViewInit {

    //传入一个Layout
    public abstract Object setLayout();

    public abstract void onBindView(Bundle savedInstanceState, View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = null;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        }
        if (rootView != null) {
            onBindView(savedInstanceState, rootView);
        }
        return rootView;
    }

    public final BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }


//    private FrameLayout titleBar;
//    private FrameLayout content;
//    protected TitleManager titleManager;
//
//    protected enum TitleType {
//        none, maintitle, backtitle
//    }
//
//    abstract protected int titleLayoutId();
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.activity_base, container, false);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        titleManager = new TitleManager((BaseActivity) this.getActivity(), R.id.activity_base_titlebar, this.getView());
//        content = (FrameLayout) this.getView().findViewById(R.id.activity_base_content);
//        titleManager.setTitleBar(titleLayoutId());
//        if (titleLayoutId() != 0) {
//            titleManager.showTitleBar();
//        } else {
//            titleManager.hideTitleBar();
//        }
//        initData();
//        initView();
//        initListener();
//    }
//
//    /**
//     * 设置内容布局
//     *
//     * @param layoutResID
//     */
//    protected void setContent(int layoutResID) {
//        content.removeAllViews();
//        LayoutInflater.from(this.getActivity()).inflate(layoutResID, content);
//    }
//
//    public void setTitleName(String title) {
//        titleManager.setTitleName(title);
//    }
//
//    public void setTitleBackGround(int resId) {
//        titleManager.setTitleBackGround(resId);
//    }

}

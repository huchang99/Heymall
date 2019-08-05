package com.hc.baselibrary.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.hc.baselibrary.R;
import com.hc.baselibrary.common.AppManager;
import com.hc.baselibrary.widgets.TitleManager;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseActivity extends SupportActivity implements ViewInit {

    protected TitleManager titleManager;
    private FrameLayout content;

    abstract protected int titleLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(initLayout());
        setContentView(R.layout.activity_base);
        AppManager.getInstance().addActivity(this);
        titleManager = new TitleManager(this, R.id.activity_base_titlebar);
        content = findViewById(R.id.activity_base_content);
        titleManager.setTitleBar(titleLayoutId());
        if (titleLayoutId() != 0) {
            titleManager.showTitleBar();
        } else {
            titleManager.hideTitleBar();
        }
        fullscreen(false);
        initData();
        initView();
        initListener();
    }

    protected enum TitleType {
        none, maintitle, backtitle
    }

    public void setTitleName(String title) {
        titleManager.setTitleName(title);
    }

    public void setTitleBackGround(int resId) {
        titleManager.setTitleBackGround(resId);
    }

    protected void setContent(int layoutResID) {
        content.removeAllViews();
        LayoutInflater.from(this).inflate(layoutResID, content);
    }

    /**
     * 显示与隐藏状态栏
     * @param enable
     */
    protected void fullscreen(boolean enable) {
        if (enable) { //显示状态栏
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(lp);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else { //隐藏状态栏
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(lp);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().finishActivity(this);
    }
}

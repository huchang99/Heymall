package com.hc.baselibrary.ui.activity;

import com.hc.baselibrary.R;

public abstract class BaseViewActivity extends BaseActivity {

    public abstract TitleType getTitleType();

    @Override
    protected int titleLayoutId() {
        switch (getTitleType()) {
            case none:
                return 0;
            case maintitle:
                return R.layout.title_bar_main;
            case backtitle:
                return 0;
            default:
                break;
        }
        return 0;
    }
}

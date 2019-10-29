package com.hc.baselibrary.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hc.baselibrary.presenter.BasePresenter;
import com.hc.baselibrary.presenter.view.BaseView;

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseViewActivity implements BaseView {

    protected T mPresenter;

    public abstract T createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView(this);
        }
        super.onDestroy();
    }
}

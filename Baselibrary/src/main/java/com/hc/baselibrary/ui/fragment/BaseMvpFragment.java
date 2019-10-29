package com.hc.baselibrary.ui.fragment;

import com.hc.baselibrary.presenter.BasePresenter;
import com.hc.baselibrary.presenter.view.BaseView;
import com.hc.baselibrary.model.BottomItemFragment;

public abstract class BaseMvpFragment<T extends BasePresenter> extends BottomItemFragment implements BaseView {

    protected T mPresenter;

    public abstract T createPresenter();

    @Override
    protected void initPView() {

        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.initPView();
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView(this);
        }
        super.onDestroyView();
    }
}

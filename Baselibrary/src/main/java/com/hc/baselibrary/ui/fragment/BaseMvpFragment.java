package com.hc.baselibrary.ui.fragment;

import com.hc.baselibrary.presenter.BasePresenter;
import com.hc.baselibrary.presenter.view.BaseView;

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {
}

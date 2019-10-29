package com.hc.baselibrary.presenter;

import com.hc.baselibrary.data.BaseModel;
import com.hc.baselibrary.presenter.view.BaseView;

public abstract class  BasePresenter<V extends BaseView, M extends BaseModel> {

    protected V mView;
    protected M mModel;

    public abstract M createModel();

    public BasePresenter() {
        mModel = createModel();
    }

    public void attachView(V mView) {
        this.mView = mView;
    }

    public void detachView(V mView) {
        this.mView = null;
    }

    /**
     * 是否与View建立连接
     */
    public boolean isViewAttached() {
        return mView != null;
    }


}

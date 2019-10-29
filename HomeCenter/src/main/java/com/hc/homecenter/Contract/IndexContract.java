package com.hc.homecenter.Contract;

import com.hc.baselibrary.data.BaseModel;
import com.hc.baselibrary.presenter.BasePresenter;
import com.hc.baselibrary.presenter.view.BaseView;

public interface IndexContract {
    interface IndexView extends BaseView {

    }

    interface IndexModel extends BaseModel {

    }

    abstract class IndexPresenter extends BasePresenter<IndexView, IndexModel> {

    }
}

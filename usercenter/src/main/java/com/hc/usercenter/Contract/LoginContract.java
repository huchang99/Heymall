package com.hc.usercenter.Contract;

import com.hc.baselibrary.data.BaseModel;
import com.hc.baselibrary.presenter.BasePresenter;
import com.hc.baselibrary.presenter.view.BaseView;

public interface LoginContract {

    interface iLoginData extends BaseModel {
        void LoginUserData(String phone, String password, LoginCallback callback);
    }

    interface iLoginView extends BaseView {
        void UpdateResult(String msgState);
    }

    abstract class iLoginPresenter extends BasePresenter<LoginContract.iLoginView, LoginContract.iLoginData> {
        public abstract void reportUserDataPwd(String edit_sign_up_phone_str,
                                             String edit_sign_up_password_str);
    }
}

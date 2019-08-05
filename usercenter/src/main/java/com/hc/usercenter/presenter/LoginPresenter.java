package com.hc.usercenter.presenter;

import com.hc.usercenter.Contract.LoginCallback;
import com.hc.usercenter.Contract.LoginContract;
import com.hc.usercenter.data.LoginDataModel;

public class LoginPresenter extends LoginContract.iLoginPresenter {
    @Override
    public void reportUserDataPwd(String edit_sign_up_phone_str, String edit_sign_up_password_str) {
        mModel.LoginUserData(edit_sign_up_phone_str, edit_sign_up_password_str, new LoginCallback() {
            @Override
            public void onResponseLoginState(String msgState) {
                mView.UpdateResult(msgState);
            }
        });
    }

    @Override
    public LoginContract.iLoginData createModel() {
        return new LoginDataModel();
    }
}
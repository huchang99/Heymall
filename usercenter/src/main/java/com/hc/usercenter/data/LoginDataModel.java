package com.hc.usercenter.data;

import com.hc.usercenter.Contract.LoginCallback;
import com.hc.usercenter.Contract.LoginContract;
import com.hc.usercenter.Contract.RegisterCallback;

public class LoginDataModel implements LoginContract.iLoginData {

    @Override
    public void LoginUserData(String phone, String password, LoginCallback callback) {
        //上传给后台数据
        callback.onResponseLoginState("登录成功");
    }
}

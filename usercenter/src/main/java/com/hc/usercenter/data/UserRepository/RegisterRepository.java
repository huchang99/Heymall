package com.hc.usercenter.data.UserRepository;

import com.hc.baselibrary.data.BaseApi.BaseResp;
import com.hc.baselibrary.data.net.RetrofitFactory;
import com.hc.usercenter.data.api.UserApi;

import io.reactivex.Observable;

/**l
 * 请求网络register
 */
public class RegisterRepository {

   public Observable<BaseResp<String>> registerNet(String name, String phone, String password) {
        return RetrofitFactory.getInstance().create(UserApi.class)
                .getRegisterStatus();
    }
}

package com.hc.usercenter.data.api;

import com.hc.baselibrary.data.BaseApi.BaseResp;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface UserApi {

    @GET("login")
    Observable<BaseResp<String>> getLoginStatus();

    @GET("register")
    Observable<BaseResp<String>> getRegisterStatus();
}

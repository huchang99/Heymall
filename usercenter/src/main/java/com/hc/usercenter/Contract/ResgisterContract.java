package com.hc.usercenter.Contract;

import com.hc.baselibrary.data.BaseApi.BaseResp;
import com.hc.baselibrary.data.BaseModel;
import com.hc.baselibrary.presenter.BasePresenter;
import com.hc.baselibrary.presenter.view.BaseView;

import io.reactivex.Observable;


/**
 * @author huchang
 * 用户注册集合接口
 */
public interface ResgisterContract {

    interface iRegisterData extends BaseModel {
        void registerSaveUserData(String name, String phone, String password, RegisterCallback callback);
        Observable<String> RxRegisterSaveUserData(String name, String phone, String password);

    }

    interface iRegisterView extends BaseView {
        void UpdateResult(String msgState);
    }

    abstract class iRegisterPresenter extends BasePresenter<iRegisterView, iRegisterData> {
        public abstract void savaUserDataPwd(String edit_sign_up_name_str,
                                             String edit_sign_up_phone_str,
                                             String edit_sign_up_password_str);
    }
}


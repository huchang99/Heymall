package com.hc.usercenter.presenter;

import com.hc.baselibrary.rx.BaseObserver;
import com.hc.usercenter.Contract.ResgisterContract;
import com.hc.usercenter.data.RegisterDataModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter extends ResgisterContract.iRegisterPresenter {

    @Override
    public ResgisterContract.iRegisterData createModel() {
        return new RegisterDataModel();
    }


    @Override
    public void savaUserDataPwd(String edit_sign_up_name_str, String edit_sign_up_phone_str, String edit_sign_up_password_str) {
//        mModel.registerSaveUserData(edit_sign_up_name_str, edit_sign_up_phone_str, edit_sign_up_password_str, new RegisterCallback() {
//            @Override
//            public void onResponseState(String msgState) {
//                mView.UpdateResult(msgState);
//            }
//        });
        // mModel.RxRegisterSaveUserData(edit_sign_up_name_str, edit_sign_up_phone_str, edit_sign_up_password_str)
        mModel.RxRegisterSaveUserData(edit_sign_up_name_str, edit_sign_up_phone_str, edit_sign_up_password_str)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())   //
                .subscribe(new BaseObserver<String>(){
                    @Override
                    public void onNext(String o) {
                        //super.onNext(o);
                        mView.UpdateResult(o);
                    }
                });

    }


}



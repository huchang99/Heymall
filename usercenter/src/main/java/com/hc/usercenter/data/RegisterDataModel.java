package com.hc.usercenter.data;

import android.util.Log;

import com.hc.baselibrary.data.BaseApi.BaseResp;
import com.hc.baselibrary.data.BaseModel;
import com.hc.usercenter.Contract.RegisterCallback;
import com.hc.usercenter.Contract.ResgisterContract;
import com.hc.usercenter.data.UserRepository.RegisterRepository;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class RegisterDataModel implements ResgisterContract.iRegisterData {

    private final static String TAG = "RegisterDataModel";

    @Override
    public void registerSaveUserData(String name, String phone, String password, RegisterCallback callback) {
        Log.d(TAG, name);
        Log.d(TAG, phone);
        Log.d(TAG, password);
        callback.onResponseState("saveOk");
    }

    @Override
    public Observable<String> RxRegisterSaveUserData(String name, String phone, String password) {
        Log.d(TAG, name);
        Log.d(TAG, phone);
        Log.d(TAG, password);
        RegisterRepository mRegisterRepository = new RegisterRepository();

        // return Observable.just("RxSaveOk");
        return mRegisterRepository.registerNet(name, phone, password)
                .flatMap(new Function<BaseResp<String>, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(BaseResp<String> stringBaseResp) throws Exception {
                        return Observable.just(stringBaseResp.getMessage());
                    }
                });
    }

}

package com.hc.usercenter.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.hc.baselibrary.ui.activity.BaseMvpActivity;
import com.hc.usercenter.Contract.LoginContract;
import com.hc.usercenter.R;
import com.hc.usercenter.presenter.LoginPresenter;


@Route(path = "/account/login")
public class LoginActivity extends BaseMvpActivity implements View.OnClickListener, LoginContract.iLoginView {

    private LoginPresenter mLoginPresenter;

    private EditText edit_sign_in_phone;
    private EditText edit_sign_in_password;
    private Button btn_sign_in;

    private String edit_sign_in_phone_str;
    private String edit_sign_in_password_str;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.attachView(this);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        this.setContent(R.layout.activity_login);
        edit_sign_in_phone = findViewById(R.id.edit_sign_in_phone);
        edit_sign_in_password = findViewById(R.id.edit_sign_in_password);
        btn_sign_in = findViewById(R.id.btn_sign_in);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        btn_sign_in.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sign_in) {
            edit_sign_in_phone_str = edit_sign_in_phone.getText().toString();
            edit_sign_in_password_str = edit_sign_in_password.getText().toString();
            mLoginPresenter.reportUserDataPwd(edit_sign_in_phone_str, edit_sign_in_password_str);
        }

    }

    @Override
    public void UpdateResult(String msgState) {
        Toast.makeText(this, msgState, Toast.LENGTH_SHORT).show();
    }

    @Override
    public TitleType getTitleType() {
        return TitleType.none;
    }
}

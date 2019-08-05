package com.hc.usercenter.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hc.baselibrary.ui.activity.BaseMvpActivity;
import com.hc.usercenter.Contract.ResgisterContract;
import com.hc.usercenter.R;
import com.hc.usercenter.presenter.RegisterPresenter;


@Route(path = "/account/register")
public class RegisterActivity extends BaseMvpActivity implements ResgisterContract.iRegisterView, View.OnClickListener {


    private RegisterPresenter mPresenter;
    //控件
    private EditText edit_sign_up_name;
    private EditText edit_sign_up_phone;
    private EditText edit_sign_up_password;
    private EditText edit_sign_up_re_password;
    private Button btn_sign_up;

    private String edit_sign_up_name_str;
    private String edit_sign_up_phone_str;
    private String edit_sign_up_password_str;
    private String edit_sign_up_re_password_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new RegisterPresenter();
        mPresenter.attachView(this);
        mPresenter.createModel();

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
       // this.setContentView(R.layout.activity_register);
        this.setContent(R.layout.activity_register);
        edit_sign_up_name = findViewById(R.id.edit_sign_up_name);
        edit_sign_up_phone = findViewById(R.id.edit_sign_up_phone);
        edit_sign_up_password = findViewById(R.id.edit_sign_up_password);
        edit_sign_up_re_password = findViewById(R.id.edit_sign_up_re_password);
        btn_sign_up = findViewById(R.id.btn_sign_up);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        btn_sign_up.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sign_up) {
            edit_sign_up_name_str = edit_sign_up_name.getText().toString();
            edit_sign_up_phone_str = edit_sign_up_phone.getText().toString();
            edit_sign_up_password_str = edit_sign_up_password.getText().toString();
            edit_sign_up_re_password_str = edit_sign_up_re_password.getText().toString();
            mPresenter.savaUserDataPwd(edit_sign_up_name_str, edit_sign_up_phone_str, edit_sign_up_password_str);
        }
    }

    @Override
    public void UpdateResult(String msgState) {
        Toast.makeText(this, msgState, Toast.LENGTH_SHORT).show();
    }

    @Override
    public TitleType getTitleType() {
        return TitleType.maintitle;
    }
}

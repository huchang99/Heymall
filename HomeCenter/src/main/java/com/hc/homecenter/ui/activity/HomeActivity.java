package com.hc.homecenter.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hc.baselibrary.ui.activity.BaseViewActivity;
import com.hc.homecenter.R;
import com.hc.homecenter.ui.fragment.bottom.MainBottomFragment;

public class HomeActivity extends BaseViewActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public TitleType getTitleType() {
        return TitleType.none;
    }

    @Override
    public void initView() {
        this.setContent(new MainBottomFragment());

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}

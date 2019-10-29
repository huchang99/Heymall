package com.hc.heymall.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hc.baselibrary.ui.activity.BaseActivity;
import com.hc.baselibrary.ui.activity.BaseViewActivity;
import com.hc.heymall.R;

public class MainActivity extends BaseViewActivity implements View.OnClickListener {

    private Button jump_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
    }

    @Override
    public TitleType getTitleType() {
        return TitleType.none;
    }


    @Override
    public void initView() {
        // this.setContent(R.layout.activity_main);
        //jump_btn = findViewById(R.id.jump_btn);
      //  this.setContent(new MainBottomFragment());
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        //jump_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.jump_btn:
//                //跳转登陆组件
//                ARouter.getInstance().build("/account/register").navigation();
//                break;
        }
    }

}

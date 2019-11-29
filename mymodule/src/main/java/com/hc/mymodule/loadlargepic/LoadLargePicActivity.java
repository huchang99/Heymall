package com.hc.mymodule.loadlargepic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hc.baselibrary.ui.activity.BaseViewActivity;
import com.hc.mymodule.R;
import com.hc.mymodule.loadlargepic.view.LargeImageView;

import java.io.IOException;
import java.io.InputStream;

public class LoadLargePicActivity extends BaseViewActivity {

    private LargeImageView mLargeImageView;


    @Override
    public TitleType getTitleType() {
        return TitleType.none;
    }

    @Override
    public void initView() {
        setContent(R.layout.activity_load_large_pic);
        mLargeImageView = findViewById(R.id.id_largetImageview);

        try
        {
            InputStream inputStream = this.getResources().getAssets().open("qm.jpg");
            mLargeImageView.setInputStream(inputStream);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}

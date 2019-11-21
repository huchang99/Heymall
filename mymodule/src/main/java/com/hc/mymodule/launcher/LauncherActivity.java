package com.hc.mymodule.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.hc.baselibrary.ui.activity.BaseViewActivity;
import com.hc.baselibrary.utils.ToastUtils;
import com.hc.mymodule.R;
import com.hc.mymodule.launcher.adapter.LaunchViewPagerAdapter;

import java.util.ArrayList;

public class LauncherActivity extends BaseViewActivity {

    private ViewPager viewPager;
    private LaunchViewPagerAdapter adapter;
    private ArrayList<View> views = new ArrayList<>();
    private AlphaAnimation alphaAnimation;
    private View v3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        //全屏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        viewPager.setCurrentItem(0);
    }

    @Override
    public TitleType getTitleType() {
        return TitleType.none;
    }

    @Override
    public void initView() {
        setContent(R.layout.activity_launcher);
        viewPager = findViewById(R.id.viewPager);

        LayoutInflater inflater = LayoutInflater.from(this);
        View v1 = inflater.inflate(R.layout.actvity_launch_viewpager_view1, null);
        views.add(v1);
        View v2 = inflater.inflate(R.layout.activity_launch_viewpager_view2, null);
        views.add(v2);
        v3 = inflater.inflate(R.layout.activity_launch_viewpager_view3, null);
        views.add(v3);

        adapter = new LaunchViewPagerAdapter(views);
        viewPager.setAdapter(adapter);

    }

    @Override
    public void initData() {
//        initAnim();
    }

    @Override
    public void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShortToast(getApplication(),"立即进入");
            }
        });
    }

    private void initAnim() {
        alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setDuration(500);
    }

}

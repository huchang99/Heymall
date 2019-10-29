package com.hc.mymodule.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hc.mymodule.R;
import com.hc.mymodule.view.SlidingPaneLayout;

public class SideBaseActivity  extends Activity implements SlidingPaneLayout.PanelSlideListener {

    //滑动开关
    private boolean swipeEnable = true; //默认关闭
    private SlidingPaneLayout slidingPaneLayout;
    private int mShadowResource = R.drawable.shadow_left;
    private Drawable mShadowDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        if (swipeEnable) {
            ViewGroup localViewGroup = (ViewGroup) getWindow().getDecorView();
            View localView = localViewGroup.getChildAt(0);
            localViewGroup.removeView(localView);
            slidingPaneLayout = new SlidingPaneLayout(this);
            slidingPaneLayout.setPanelSlideListener( this);
            slidingPaneLayout.setSliderFadeColor(getResources().getColor(android.R.color.transparent));
            slidingPaneLayout.setShadowResource(mShadowResource);
            if (mShadowDrawable != null) {
                slidingPaneLayout.setShadowDrawable(mShadowDrawable);
            }
            slidingPaneLayout.setCoveredFadeColor(getResources().getColor(android.R.color.transparent));
            /* slidingPaneLayout.setBackgroundColor(Color.alpha(0)); */

            View localViewTemp = new TextView(this);
            /*
             * localViewTemp.setTextColor(getResources().getColor(R.color.beta));
             * localViewTemp.setBackgroundResource(android.R.color.black);
             */
            // ViewHelper.setAlpha(localViewTemp, 0.0f);
            ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            slidingPaneLayout.addView(localViewTemp, localLayoutParams);
            slidingPaneLayout.addView(localView);
            localViewGroup.addView(slidingPaneLayout);
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {

    }

    @Override
    public void onPanelOpened(View panel) {
        super.finish();
    }

    @Override
    public void onPanelClosed(View panel) {

    }

    /**
     *
     * Description: 滑动效果是否打开
     * @return
     * @Author wf
     * Create Date: 2015-8-4 上午9:57:19
     */
    public boolean isSwipeEnable() {
        return swipeEnable;
    }

    /**
     *
     * Description:设置滑动效果是否打开
     * @param swipeEnable
     * @Author wf
     * Create Date: 2015-8-4 上午9:57:39
     */
    public void setSwipeBackEnable(boolean swipeEnable) {
        /*
         * if (BuildConfig.DEBUG)LogUtils.i(TAG,
         * "setSwipeEnable >> swipeEnable >> "+swipeEnable);
         */
        this.swipeEnable = swipeEnable;
    }

    /**
     *
     * Description: 设置阴影效果
     * @param d
     * @Author wf
     * Create Date: 2015-8-4 上午9:58:06
     */
    public void setShadowDrawable(Drawable d) {
        mShadowDrawable = d;
    }

    /**
     * 设置阴影效果
     * Description:
     * @param resId
     * @Author wf
     * Create Date: 2015-8-4 上午9:58:51
     */
    public void setShadowResource(int resId) {
        mShadowResource = resId;
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    public void addIgnoredView(View v) {
        slidingPaneLayout.addIgnoredView(v);
    }
}

package com.hc.baselibrary.model;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.hc.baselibrary.R;
import com.hc.baselibrary.ui.fragment.BaseFragment;

public abstract class BottomItemFragment extends BaseFragment implements View.OnKeyListener {

    //当前按下返回按钮的时间
    private long mExitTime = 0;
    //双击返回键之间的延迟
    private static final int EXIT_TIME = 2000;

    @Override
    public void onResume() {
        super.onResume();
        View rootView = getView();
        //防止双击退出失效
        if(rootView != null){
            rootView.setFocusableInTouchMode(true);//实现View的点击事件
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-mExitTime)>EXIT_TIME){
                Toast.makeText(getContext(),"双击退出"+getString(R.string.app_name),Toast.LENGTH_LONG).show();
                mExitTime = System.currentTimeMillis();
            }
            else{
                getActivity().finish();
                if(mExitTime!=0)
                    mExitTime = 0;
            }
            return true;
        }
        return false;
    }
}

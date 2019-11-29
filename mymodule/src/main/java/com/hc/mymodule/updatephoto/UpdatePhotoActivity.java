package com.hc.mymodule.updatephoto;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hc.baselibrary.ui.activity.BaseViewActivity;
import com.hc.baselibrary.utils.AppExceptionHandler;
import com.hc.baselibrary.utils.CutPicUtils;
import com.hc.mymodule.R;

import java.io.File;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

/**
 * 更新头像
 */
public class UpdatePhotoActivity extends BaseViewActivity implements View.OnClickListener {

    private static final int REQUEST_PERMISSION_CAMERA = 0x102;
    private static final int REQUEST_PERMISSION_ALBUM = 0x112;
    private static final int REQUEST_CODE_CAMERA = 0x002;
    private static final int REQUEST_CODE_ALBUM = 0x012;
    private static final int REQUEST_CODE_CROP = 0x102;

    private File cameraFile;
    private LinearLayout ll_avatar_layout;
    private PopupWindow pop;
    private ImageView iv_avatat;
    private Uri cropUri;


    @Override
    public TitleType getTitleType() {
        return TitleType.none;
    }

    @Override
    public void initView() {
        setContent(R.layout.activity_update_photo);
        ll_avatar_layout = findViewById(R.id.ll_avatar_layout);
        iv_avatat = findViewById(R.id.iv_avatat);

    }

    @Override
    public void initData() {
        AsyncTask
    }

    @Override
    public void initListener() {
        ll_avatar_layout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_avatar_layout: {
                showPop();
                break;
            }
        }
    }

    /**
     * 弹出底部弹窗
     */
    private void showPop() {
        View bottomView = View.inflate(this, R.layout.layout_bottom_dialog, null);
        TextView mAlbum = bottomView.findViewById(R.id.tv_album);
        TextView mCamera = bottomView.findViewById(R.id.tv_camera);
        TextView mCancle = bottomView.findViewById(R.id.tv_cancel);

        pop = new PopupWindow(bottomView, -1, -2);
        pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
//        pop.setAnimationStyle(R.style.FullTheme);
        pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tv_album: { //相册
                        PermissionGen.needPermission(UpdatePhotoActivity.this, REQUEST_PERMISSION_ALBUM, new String[]{
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                                }
                        );
                        break;
                    }
                    case R.id.tv_camera: { //相机
                        PermissionGen.needPermission(UpdatePhotoActivity.this, REQUEST_PERMISSION_CAMERA, new String[]{
                                        Manifest.permission.CAMERA,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                                }
                        );
                        break;
                    }
                    case R.id.tv_cancel: { //取消
                        closePopupwindow();
                        break;
                    }
                }
            }
        };

        mAlbum.setOnClickListener(onClickListener);
        mCamera.setOnClickListener(onClickListener);
        mCancle.setOnClickListener(onClickListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = REQUEST_PERMISSION_ALBUM)
    public void doSuccessAlbum() {
        CutPicUtils.getInstance().StartActivityToAlbm(this, REQUEST_CODE_ALBUM);
        closePopupwindow();
    }

    @PermissionFail(requestCode = REQUEST_PERMISSION_ALBUM)
    public void doFailAlbum() {
        closePopupwindow();
    }

    @PermissionSuccess(requestCode = REQUEST_PERMISSION_CAMERA)
    public void doSuccessCamera() {
        cameraFile = CutPicUtils.getInstance().StartActivityToCamera(this, REQUEST_CODE_CAMERA);
        closePopupwindow();
    }

    @PermissionFail(requestCode = REQUEST_PERMISSION_CAMERA)
    public void doFailCamera() {
        closePopupwindow();
    }

    private void closePopupwindow() {
        if (pop != null && pop.isShowing()) {
            pop.dismiss();
            pop = null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CAMERA: {
                    try {
                        Uri uri;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            uri = FileProvider.getUriForFile(this, "com.hc.mymodule.fileProvider", cameraFile);
                        } else {
                            uri = Uri.fromFile(cameraFile);
                        }
                        cropUri = CutPicUtils.getInstance().StartActivityToCrop(this,
                                REQUEST_CODE_CROP, uri);
                    } catch (Exception e) {
                        AppExceptionHandler.doHandle(e);
                    }
                    break;
                }
                case REQUEST_CODE_ALBUM: {
                    try {
                        cropUri = CutPicUtils.getInstance().StartActivityToCrop(this,
                                REQUEST_CODE_CROP, data.getData());
                    } catch (Exception e) {
                        AppExceptionHandler.doHandle(e);
                    }
                    break;
                }
                case REQUEST_CODE_CROP: {
                    try {
                        Glide.with(this)
                                .setDefaultRequestOptions(new RequestOptions()
                                        .placeholder(R.drawable.ic_avatar)
                                        .circleCrop())
                                .load(cropUri)
                                .into(iv_avatat);
                    } catch (Exception e) {
                        AppExceptionHandler.doHandle(e);
                    }
                    break;
                }
            }
        }
    }
}

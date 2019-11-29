package com.hc.baselibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;


import java.io.File;
import java.io.FileNotFoundException;

public class CutPicUtils {
    private volatile static CutPicUtils instance;

    private CutPicUtils() {}

    public static CutPicUtils getInstance() {
        if (instance == null) {
            synchronized (CutPicUtils.class) {
                if (instance == null) {
                    instance = new CutPicUtils();
                }
            }
        }

        return instance;
    }

    /**
     * 从相机获取图片
     */
    public File StartActivityToCamera(Activity activity, int requestCode) {
        //用于保存调用相机拍照后所生成的文件
        File cameraFile = new File(getImagePath(), "Camera_" + System.currentTimeMillis() + ".jpg");
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {   //如果在Android7.0以上,
            // 使用FileProvider获取Uri
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(activity, activity.getApplication()
                    .getPackageName() + ".fileProvider", cameraFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        } else {    //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(cameraFile));
        }
        activity.startActivityForResult(intent, requestCode);
        return cameraFile;
    }

    /**
     * 从相册获取图片
     */
    public void StartActivityToAlbm(Activity activity, int requestCode) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        activity.startActivityForResult(photoPickerIntent, requestCode);
    }

    /**
     * 图片剪切
     */
    public Uri StartActivityToCrop(Activity activity, int resultCode, Uri uri) {
        try {
            Uri imageUri = Uri.fromFile(new File(getImagePath(), "Crop_" + System
                    .currentTimeMillis() + ".jpg"));
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", DisplayUtils.dpToPx(100));
            intent.putExtra("outputY", DisplayUtils.dpToPx(100));
            intent.putExtra("scale", true);
            intent.putExtra("return-data", false);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            intent.putExtra("noFaceDetection", false);
            activity.startActivityForResult(intent, resultCode);

            return imageUri;
        } catch (Exception e) {
            AppExceptionHandler.doHandle(e);
        }
        return null;
    }

    /**
     * 根据裁剪返回的Uri生成位图图片
     */
    public Bitmap decodeUriAsBitmap(Uri uri, Context context) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }

    private String getImagePath() {
        if (!TextUtils.isEmpty(StoragePathConfig.getImagePath())) {
            File file = new File(StoragePathConfig.getImagePath());
            if (!file.exists()) {
                file.mkdirs();
            }
            return StoragePathConfig.getImagePath();
        } else {
            return Environment.getExternalStorageDirectory().getPath();
        }
    }
}

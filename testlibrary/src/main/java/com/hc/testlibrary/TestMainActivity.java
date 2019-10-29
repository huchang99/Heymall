package com.hc.testlibrary;

import android.Manifest;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.hc.baselibrary.data.net.RetrofitFactory;
import com.hc.baselibrary.rx.BaseObserver;
import com.hc.baselibrary.utils.Loghc;
import com.hc.testlibrary.data.api.FaceApi;
import com.hc.testlibrary.data.model.Detectface;
import com.hc.testlibrary.data.model.FaceCreateSet;
import com.hc.testlibrary.data.model.FaceDetectResponse;
import com.hc.testlibrary.data.model.FaceSetRequest;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

import static android.Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS;

public class TestMainActivity extends AppCompatActivity {


    private Button test_bt;
    private Button test_bt_delete;
    private Button test_bt_detect;
    private ImageView img_tv;

    // String path = "adai.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        final RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        MOUNT_UNMOUNT_FILESYSTEMS)
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
                        // I can control the camera now
                    } else {
                        // Oups permission denied
                    }
                });
        test_bt = findViewById(R.id.test_bt);
        test_bt_delete = findViewById(R.id.test_bt_delete);
        test_bt_detect = findViewById(R.id.test_bt_detect);
        img_tv = findViewById(R.id.img_tv);


        //img_dis();
        test_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFaceSettoJson();
            }
        });

        test_bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFaceSet();
            }
        });
        test_bt_detect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 detectFace();
               // img_dis();
            }
        });

    }

    //测试图片
    public void img_dis() { //getExternalStorageDirectory
//        Bitmap bm = getImageFromAssetsFile("adai.jpg");
        // bm = Bitmap.createScaledBitmap(bm, 150, 150, true);

        String path = "adai.jpg";
        File mFile = getAssetFile(path);
        Loghc.d("hchchcfile", Environment.getExternalStorageDirectory() + "");
        getFileName(Environment.getExternalStorageDirectory() + "");

//        img_tv.setImageBitmap(bm);

    }

    //测试文件夹下内容
    public static Vector<String> getFileName(String fileAbsolutePath) {
        Vector<String> vecFile = new Vector<String>();
        File file = new File(fileAbsolutePath);
        File[] subFile = file.listFiles();

        for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
            // 判断是否为文件夹
            if (!subFile[iFileLength].isDirectory()) {
                String filename = subFile[iFileLength].getName();
                Log.d("hchchcfile", "文件名 ： " + filename);
            }
        }
        return vecFile;
    }

    private File getAssetFile(String filename) {
        File targetFile = null;
        OutputStream outStream = null;

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //sd卡已装入
            Loghc.d("hchchcfile", "有SD卡");
            targetFile = new File(Environment.getExternalStorageDirectory() + "/", filename);
            if (!targetFile.exists()) {
                try {
                    targetFile.createNewFile();
                    Loghc.d("hchchcfile", "创建文件");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //文件存在，获取Asset文件夹下的图片,写入file文件
            AssetManager mAssetManager = getResources().getAssets();
            try {
                InputStream mInputStream = mAssetManager.open(filename);
                byte[] buffer = new byte[mInputStream.available()];
                mInputStream.read(buffer);

                outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
                outStream.close();
                mInputStream.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        } else {
            Loghc.d("hchchcfile", "无SD卡");
        }
        //getFileName(Environment.getExternalStorageDirectory() + "");
        return targetFile;
    }


    public void createFaceSettoJson() {
        // FaceCreateSet mfaceCreateSet = new FaceCreateSet();
        HashMap<String, Object> HashFaceset = new HashMap<String, Object>();
        HashFaceset.put("api_key", "izDnzmI_ek37QlpJ44_eu28-mR5nFStY");
        HashFaceset.put("api_secret", "-2C69CaKfxP_lZoZVEAurezV6CAL5mys");
        HashFaceset.put("outer_id", "hcFace");

        FaceApi mfaceApi = RetrofitFactory.getInstance().create(FaceApi.class);
        mfaceApi.CreateFaceSetData(HashFaceset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseObserver<FaceSetRequest>() {
                    @Override
                    public void onNext(FaceSetRequest o) {
                        super.onNext(o);
                        Loghc.d("hchccreate1", o.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Loghc.d("hchccreate2", e.toString());
                    }
                });
    }

    public void deleteFaceSet() {
        HashMap<String, Object> HashFaceset = new HashMap<String, Object>();
        HashFaceset.put("api_key", "izDnzmI_ek37QlpJ44_eu28-mR5nFStY");
        HashFaceset.put("api_secret", "-2C69CaKfxP_lZoZVEAurezV6CAL5mys");
        HashFaceset.put("outer_id", "hcFace");

        FaceApi mfaceApi = RetrofitFactory.getInstance().create(FaceApi.class);
        mfaceApi.deleteFaceSetData(HashFaceset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseObserver<FaceSetRequest>() {
                    @Override
                    public void onNext(FaceSetRequest o) {
                        super.onNext(o);
                        Loghc.d("hchcdelete", o.toString());
                    }
                });
    }

    public void detectFace() {
//        HashMap<String, Object> mfacedetect = new HashMap<>();
//        mfacedetect.put("api_key", "izDnzmI_ek37QlpJ44_eu28-mR5nFStY");
//        mfacedetect.put("api_secret", "-2C69CaKfxP_lZoZVEAurezV6CAL5mys");

        File mFile = getAssetFile("adai.jpg");
        RequestBody filebody = RequestBody.create(MediaType.parse("image/jpg"), mFile);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image_file", mFile.getName(), filebody)
                .addFormDataPart("api_key", "izDnzmI_ek37QlpJ44_eu28-mR5nFStY")
                .addFormDataPart("api_secret", "-2C69CaKfxP_lZoZVEAurezV6CAL5mys")
                .build();
        FaceApi mfaceApi = RetrofitFactory.getInstance().create(FaceApi.class);
        mfaceApi.detectFaceData(requestBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseObserver<FaceDetectResponse>() {
                    @Override
                    public void onNext(FaceDetectResponse o) {
                        super.onNext(o);
                        Loghc.d("hchcdetect1", o.toString());
                        ArrayList<Detectface> detectfaces = o.getFace_rectangle();
                        if (detectfaces != null) {
                            for (int i = 0; i < detectfaces.size(); i++) {
                                Loghc.d("hchchfacetoken", detectfaces.get(i).getFace_token() + "" + i);
                            }
                        } else {
                            Loghc.d("hchchfacetoken", "detectfaces = null");
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Loghc.d("hchcdetect2", e.toString());
                    }
                });


    }


    private Bitmap getImageFromAssetsFile(String filename) {
// picture_icon is folder in assets
        // filename = "picture_icon/" + filename;
        Bitmap mBitmap = null;
        AssetManager mAssetManager = getResources().getAssets();
        try {
            InputStream mInputStream = mAssetManager.open(filename);
            mBitmap = BitmapFactory.decodeStream(mInputStream);
            mInputStream.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            mBitmap = null;
        }
        return mBitmap;
    }


}

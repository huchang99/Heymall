package com.hc.baselibrary.data.net;

import com.hc.baselibrary.data.Interceptor.MoreBaseUrlInterceptor;

import java.util.concurrent.TimeUnit;

import io.reactivex.plugins.RxJavaPlugins;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.hc.baselibrary.data.net.BaseConstant.mOkHttpClient;


public class RetrofitFactory {

   // private static RetrofitFactory mRetrofitFactory = null;
    private Retrofit RETROFIT_ClIENT;

    private RetrofitFactory() {
        initRetrofit();
    }

    private static final class RetrofitFactoryHolder {
        public static RetrofitFactory instance = new RetrofitFactory();

    }

    public static RetrofitFactory getInstance() {
        return RetrofitFactoryHolder.instance;
    }

    private void initRetrofit() {
        if (RETROFIT_ClIENT == null)
            RETROFIT_ClIENT = new Retrofit.Builder()
                    .baseUrl("https://api-cn.faceplusplus.com/facepp/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(initClient())
                    .build();
    }

    public  <T> T create(Class<T> t) {
        return RETROFIT_ClIENT.create(t);
    }

    private OkHttpClient initClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(initLogInterceptor())
                    .addInterceptor(new MoreBaseUrlInterceptor())
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;

    }

    private Interceptor initLogInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}

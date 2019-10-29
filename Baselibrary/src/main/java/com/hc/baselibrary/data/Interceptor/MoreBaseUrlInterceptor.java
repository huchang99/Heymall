package com.hc.baselibrary.data.Interceptor;

import com.hc.baselibrary.utils.Loghc;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.hc.baselibrary.data.net.BaseConstant.BASE_FACE_URL;
import static com.hc.baselibrary.data.net.BaseConstant.BASE_URL;

public class MoreBaseUrlInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取原始的请求
        Request originRequest = chain.request();
        //获取老的url
        HttpUrl oldUrl = originRequest.url();
        //获取originalRequest创建者的builder
        Request.Builder builder = originRequest.newBuilder();
        //获取头信息的集合
        List<String> urlnameList = originRequest.headers("urlname");
        if (urlnameList != null && urlnameList.size() > 0) {
            //删除原有配置中的值
            builder.removeHeader("urlname");
            //获取头信息中配置的value
            String urlname = urlnameList.get(0);
            HttpUrl baseURL = null;
            //根据头信息中配置的value,来匹配新的base_url地址
            if ("facedetect".equals(urlname)) {
                baseURL = HttpUrl.parse(BASE_FACE_URL);
            } else {
                baseURL = HttpUrl.parse(BASE_URL);
            }
            //重新组建新的HttpUrl,需要重新设置url部分
            HttpUrl newHttpUrl = oldUrl.newBuilder()
                    .scheme(baseURL.scheme())
                    .host(baseURL.host())
                    .port(baseURL.port())
                    .build();
            Loghc.d("hchchcokhttp",newHttpUrl.toString());
            //获取处理后的新的newRequest
            Request newRequest = builder.url(newHttpUrl).build();
            return chain.proceed(newRequest);
        }
        else {
            return chain.proceed(originRequest);
        }

    }
}

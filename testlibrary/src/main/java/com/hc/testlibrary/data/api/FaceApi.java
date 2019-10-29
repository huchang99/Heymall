package com.hc.testlibrary.data.api;


import com.hc.testlibrary.data.model.FaceDetectResponse;
import com.hc.testlibrary.data.model.FaceSetRequest;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface FaceApi {

    @Headers("urlname:facedetect")
    @FormUrlEncoded
    @POST("v3/faceset/create")
    Observable<FaceSetRequest> CreateFaceSetData(@FieldMap Map<String, Object> params);

    @Headers("urlname:facedetect")
    @FormUrlEncoded
    @POST("v3/faceset/delete")
    Observable<FaceSetRequest> deleteFaceSetData(@FieldMap Map<String, Object> params);

    @Headers("urlname:facedetect")
    @POST("v3/detect")
    Observable<FaceDetectResponse> detectFaceData(@Body RequestBody body);
}

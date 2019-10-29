package com.hc.testlibrary.data.model;

import java.util.ArrayList;

public class FaceSetRequest {

    String request_id;
    String faceset_token;
    String outer_id;
    String face_added;
    String face_count;
    ArrayList<Facefailuredetail> failure_detail;
    int time_used;
    String error_message;

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getFaceset_token() {
        return faceset_token;
    }

    public void setFaceset_token(String faceset_token) {
        this.faceset_token = faceset_token;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public String getFace_added() {
        return face_added;
    }

    public void setFace_added(String face_added) {
        this.face_added = face_added;
    }

    public String getFace_count() {
        return face_count;
    }

    public void setFace_count(String face_count) {
        this.face_count = face_count;
    }

    public ArrayList<Facefailuredetail> getFailure_detail() {
        return failure_detail;
    }

    public void setFailure_detail(ArrayList<Facefailuredetail> failure_detail) {
        this.failure_detail = failure_detail;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }


    @Override
    public String toString() {
        return "FaceSetRequest{" +
                "request_id='" + request_id + '\'' +
                ", faceset_token='" + faceset_token + '\'' +
                ", outer_id='" + outer_id + '\'' +
                ", face_added='" + face_added + '\'' +
                ", face_count='" + face_count + '\'' +
                ", failure_detail=" + failure_detail +
                ", time_used=" + time_used +
                ", error_message='" + error_message + '\'' +
                '}';
    }
}

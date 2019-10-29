package com.hc.testlibrary.data.model;

import java.util.ArrayList;

public class FaceDetectResponse {
    String request_id;
    ArrayList<Detectface> face_rectangle;
    String image_id;
    int time_used;
    String error_message;


    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public ArrayList<Detectface> getFace_rectangle() {
        return face_rectangle;
    }

    public void setFace_rectangle(ArrayList<Detectface> face_rectangle) {
        this.face_rectangle = face_rectangle;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
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
        return "FaceDetectResponse{" +
                "request_id='" + request_id + '\'' +
                ", face_rectangle=" + face_rectangle +
                ", image_id='" + image_id + '\'' +
                ", time_used=" + time_used +
                ", error_message='" + error_message + '\'' +
                '}';
    }
}

package com.hc.testlibrary.data.model;

public class Detectface {

    String face_token;
    Object face_rectangle;
    Object landmark;
    Object attributes;

    public String getFace_token() {
        return face_token;
    }

    public void setFace_token(String face_token) {
        this.face_token = face_token;
    }

    public Object getFace_rectangle() {
        return face_rectangle;
    }

    public void setFace_rectangle(Object face_rectangle) {
        this.face_rectangle = face_rectangle;
    }

    public Object getLandmark() {
        return landmark;
    }

    public void setLandmark(Object landmark) {
        this.landmark = landmark;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }


    @Override
    public String toString() {
        return "Detectface{" +
                "face_token='" + face_token + '\'' +
                ", face_rectangle=" + face_rectangle +
                ", landmark=" + landmark +
                ", attributes=" + attributes +
                '}';
    }
}

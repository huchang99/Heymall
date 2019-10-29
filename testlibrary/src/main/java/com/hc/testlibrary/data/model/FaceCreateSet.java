package com.hc.testlibrary.data.model;

public class FaceCreateSet {
    String api_key;
    String api_secret;
    String display_name;
    String outer_id;
    String tags;
    String face_tokens;
    String user_data;
    int force_merge;

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getApi_secret() {
        return api_secret;
    }

    public void setApi_secret(String api_secret) {
        this.api_secret = api_secret;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getFace_tokens() {
        return face_tokens;
    }

    public void setFace_tokens(String face_tokens) {
        this.face_tokens = face_tokens;
    }

    public String getUser_data() {
        return user_data;
    }

    public void setUser_data(String user_data) {
        this.user_data = user_data;
    }

    public int getForce_merge() {
        return force_merge;
    }

    public void setForce_merge(int force_merge) {
        this.force_merge = force_merge;
    }


}

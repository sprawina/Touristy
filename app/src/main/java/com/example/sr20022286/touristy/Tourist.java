package com.example.sr20022286.touristy;

import android.media.Image;

public class Tourist {

    private String id;
    private String img;
    private String title;

    public Tourist(String id, String title, String img) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

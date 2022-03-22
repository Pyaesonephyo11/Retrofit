package com.example.retrofit.Model;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Url;

public class Data {
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;

    public Data(int id, String title,String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Url {

    @JsonProperty("url")
    private String url;


    public Url() {
    }

    public Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                '}';
    }
}

package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchUrl {
    @JsonProperty("url")
    private String url;

    @JsonProperty("depth")
    private Integer depth;

    public SearchUrl() {
    }

    public SearchUrl(String url, Integer depth) {
        this.url = url;
        this.depth = depth;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "SearchUrl{" +
                "url='" + url + '\'' +
                ", depth=" + depth +
                '}';
    }
}

package com.example.dto;

public class SearchResult {

    String pageTitle;
    String pageLink;


    public SearchResult() {
    }

    public SearchResult(String pageTitle, String pageLink) {
        this.pageTitle = pageTitle;
        this.pageLink = pageLink;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "pageTitle='" + pageTitle + '\'' +
                ", pageLink='" + pageLink + '\'' +
                '}';
    }
}

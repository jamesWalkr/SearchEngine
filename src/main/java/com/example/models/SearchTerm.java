package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchTerm {

    @JsonProperty("search_term")
    private String searchTerm;

    public SearchTerm() {
    }

    public SearchTerm(String searchTeam) {
        this.searchTerm = searchTeam;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public String toString() {
        return "SearchTerm{" +
                "searchTerm='" + searchTerm + '\'' +
                '}';
    }


}

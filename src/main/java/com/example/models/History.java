package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @JsonProperty("keyword")
    @Column(name = "keyword")
    private String keyword;

    @JsonProperty("link_to_history")
    @Column(name = "link_to_history")
    private String linkToHistory;

    public History() {
    }

    public History(String keyword, String linkToHistory) {
        this.keyword = keyword;
        this.linkToHistory = linkToHistory;
    }

    public History(Long id, String keyword, String linkToHistory) {
        this.id = id;
        this.keyword = keyword;
        this.linkToHistory = linkToHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLinkToHistory() {
        return linkToHistory;
    }

    public void setLinkToHistory(String linkToHistory) {
        this.linkToHistory = linkToHistory;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", linkToHistory='" + linkToHistory + '\'' +
                '}';
    }
}

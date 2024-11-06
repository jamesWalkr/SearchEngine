package com.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Pages")
public class PageContents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "page_title")
    private String title;

    @Lob
    @Column(name = "link", columnDefinition= "TEXT")
    private String link;

    @Lob
    @Column(name= "page_text", columnDefinition= "LONGTEXT")
    private String text;

    public PageContents() {
    }

    public PageContents(Long id, String title, String link, String text) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "PageContents{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

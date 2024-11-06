package com.example.service;

import com.example.models.PageContents;
import com.example.repository.IndexRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Service
public class WebCrawler {
    private final Logger logger = LoggerFactory.getLogger(WebCrawler.class);

    Set<String> urlSet = new HashSet<>();
    int MAX_DEPTH = 2;
    private final IndexRepo indexRepo;
    Document document;

    public  WebCrawler(IndexRepo indexRepo){
        this.indexRepo = indexRepo;
    }

    public void getPageTextAndLinks(String url, int depth) {

        if (depth > MAX_DEPTH) {
            return;
        }
        if (urlSet.contains(url)) {
            logger.debug("Already crawled Skipping...");
            return;
        }
        if (!isValidUrl(url)){
            logger.debug("Malformed url Skipping...");
            return;
        }

        logger.debug("crawling url: {} ", url);

        // depth++;

        try {
            document = Jsoup.connect(url).timeout(5000).get();
            logger.debug("title: {}", document.title());
        } catch (IOException e) {
            logger.debug("status 400 Skipping...");
            return;
        }

        /*TODO
           Indexer work starts here*/

        logger.debug("saving page contents to Database");
        var pageContent = new PageContents();
        pageContent.setTitle(document.title());
        pageContent.setLink(url);
        pageContent.setText(document.text());

        indexRepo.save(pageContent);


        Elements availableLinksOnPage = document.select("a[href]");

        for (Element currentLink : availableLinksOnPage) {
            String nexUrl = currentLink.attr("abs:href");
            getPageTextAndLinks(nexUrl, depth + 1);
        }
        urlSet.add(url);
    }
     private boolean isValidUrl(String url){
        try {
            new URL(url);
            return true;
        } catch (Exception e){
            return false;
        }
     }
}

package com.example.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CheckUrl {

    private final Logger logger = LoggerFactory.getLogger(CheckUrl.class);

    public void checkUrls(String url) {
        Connection.Response response;
        try {
            response = Jsoup.connect(url).followRedirects(false).execute();
            // int statusCode = response.statusCode();
        } catch (IOException e) {
            logger.debug("Status 400 skipping");
        }
    }

}

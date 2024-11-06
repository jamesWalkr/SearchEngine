package com.example.Controllers;

import com.example.dto.SearchResult;
import com.example.dto.Url;
import com.example.models.History;
import com.example.models.SearchTerm;
import com.example.service.CheckUrl;
import com.example.service.SearchService;
import com.example.service.WebCrawler;
import com.example.dto.SearchUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SearchController {
    private final Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final WebCrawler crawler;
    private final CheckUrl checkUrl;
    private final SearchService searchService;


    public SearchController(WebCrawler crawler, CheckUrl checkUrl, SearchService searchService) {
        this.crawler = crawler;
        this.checkUrl = checkUrl;
        this.searchService = searchService;
    }


    @GetMapping("history")
    public ResponseEntity<List<History>> getHistory(){
        List<History> response = searchService.getAllHistory();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/search")
    public List<SearchResult> submitSearchTerm(@RequestParam SearchTerm keyword){
        return searchService.Search(keyword);

    }
    @PostMapping("/links")
    public  ResponseEntity<String> getTextAndLinks(@RequestBody SearchUrl url){
        logger.debug("This message is coming from com.example.Controllers.SearchController");
        logger.debug("Request contains: {} {}", url.getUrl(), url.getDepth());
        crawler.getPageTextAndLinks(url.getUrl(), url.getDepth());
        return ResponseEntity.status(HttpStatus.OK).body("you request was successful. please see logs");
    }
    @PostMapping("/check")
    public ResponseEntity<String> checkUrls(@RequestBody Url url){
        checkUrl.checkUrls(url.getUrl());
        return ResponseEntity.status(HttpStatus.OK).body("you request was successful. please see logs");
    }
}

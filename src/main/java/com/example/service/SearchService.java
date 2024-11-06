package com.example.service;

import com.example.dto.SearchResult;
import com.example.models.History;
import com.example.models.SearchTerm;
import com.example.repository.HistoryRepo;
import com.example.repository.SearchRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final SearchRepo searchRepo;
    private final HistoryRepo historyRepo;

    public SearchService(SearchRepo searchRepo, HistoryRepo historyRepo) {
        this.searchRepo = searchRepo;
        this.historyRepo = historyRepo;
    }

    public List<SearchResult> Search(SearchTerm searchTerm) {
        // save History object to table
        String link = "http://localhost:8080/api/v1/search?keyword=";
        History history = new History(searchTerm.getSearchTerm(), link + searchTerm.getSearchTerm());
        historyRepo.save(history);
        return searchRepo.FindSearchResults(searchTerm);
    }

    public List<History> getAllHistory(){
        return historyRepo.findAll();
    }


}

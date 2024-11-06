package com.example.repository;

import com.example.dto.SearchResult;
import com.example.models.SearchTerm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchRepo{
    //SELECT P.page_title  +
    //",p.link
    // ,(length(lower(p.page_text))-length(replace(lower(p.page_text), ':keyword', '')))/length(':keyword')
    // as countoccurence
    // from pages p
    // order by concurrence
    // desc "limit 30";

    @PersistenceContext
    private EntityManager entityManager;



    public List<SearchResult> FindSearchResults ( SearchTerm searchTerm){

        String getCountOccurenceQuery = "SELECT page_title " +
                ",link " +
                ",(LENGTH(LOWER(page_text))-LENGTH(REPLACE(LOWER(page_text), '"+ searchTerm.getSearchTerm() +"', '')))/LENGTH('"+ searchTerm.getSearchTerm() +"') " +
                "AS countoccurence " +
                "FROM pages " +
                "ORDER BY countoccurence " +
                "DESC LIMIT 30";

        Query query =  entityManager.createNativeQuery(getCountOccurenceQuery);

        List<Object[]> response = query.getResultList();

        List<SearchResult> searchResultList = new ArrayList<SearchResult>() {
        };
        for (Object[] obj : response){
            SearchResult searchResultObj = new SearchResult();
            searchResultObj.setPageTitle((String) obj[0]);
            searchResultObj.setPageLink((String) obj[1]);
            searchResultList.add(searchResultObj);
        }
        return searchResultList;





    }
}

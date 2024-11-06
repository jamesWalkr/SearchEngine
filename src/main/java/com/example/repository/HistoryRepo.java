package com.example.repository;

import com.example.models.History;
import com.example.models.SearchTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<History, Long> {

}

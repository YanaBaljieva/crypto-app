package com.example.demo.repository;

import com.example.demo.models.TransactionsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsHistoryRepository extends JpaRepository<TransactionsHistory, Integer> {
}

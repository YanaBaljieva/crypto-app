package com.example.demo.repository;

import com.example.demo.models.TransactionsHistory;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<TransactionsHistory> findById(int id);
}

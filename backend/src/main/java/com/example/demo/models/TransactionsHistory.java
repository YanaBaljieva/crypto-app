package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transactions_History")
public class TransactionsHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cryptoName;
    private String amount;

    private LocalDateTime dateOfTransaction;
    private CryptoAction cryptoAction;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

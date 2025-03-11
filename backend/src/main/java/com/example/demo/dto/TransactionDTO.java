package com.example.demo.dto;

import com.example.demo.models.CryptoAction;

import java.time.LocalDateTime;

public class TransactionDTO {
    private double amount;

    private String symbol;
    private LocalDateTime transactionDate;

    private double price;
    private CryptoAction cryptoAction;

    public TransactionDTO(String symbol, double amount, double price, CryptoAction cryptoAction) {
        this.symbol = symbol;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.cryptoAction = cryptoAction;
        this.price = price;
    }


    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public CryptoAction getCryptoAction() {
        return cryptoAction;
    }


}

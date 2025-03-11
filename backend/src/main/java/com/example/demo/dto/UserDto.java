package com.example.demo.dto;

import com.example.demo.models.CryptoAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private int id;

    private String username;

    private String email;
    private String password;

    private double balance = 10000;

    private static final int DEFAULT_BALANCE = 10000;
    private List<TransactionDTO> transactionDTOS = new ArrayList<>();


    public double getBalance() {
        return balance;
    }

    public List<TransactionDTO> getTransactionDTOS() {
        return transactionDTOS;
    }



    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDefaultBalance() {
        this.balance = DEFAULT_BALANCE;
    }


    public void setTransactionDTOS() {
        this.transactionDTOS.clear();
    }

    public void addTransaction(String symbol, double amount, Double price, CryptoAction cryptoAction) {
        TransactionDTO transactionDTO = new TransactionDTO(symbol, amount, price, cryptoAction);
        transactionDTOS.add(transactionDTO);
    }
}

package com.example.demo.services;

//import com.example.demo.dto.CryptoCurrencyDTO;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.dto.UserDto;
import com.example.demo.models.CryptoAction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CryptoService {

    private UserDto userDto = new UserDto();
    private final RestTemplate restTemplate = new RestTemplate();
    private final Map<String, Object> cryptoList = new HashMap<>();
    private static final String BASE_API_URL = "https://api.kraken.com/0/public/Ticker?pair=";
    private static final List<String> TOP_CURRENCIES = Arrays.asList(
            "XBTUSD", "ETHUSD", "XRPUSD", "USDTUSD", "SOLUSD", "USDCUSD", "ADAUSD",
            "DOGEUSD", "TRXUSD", "WBTCUSD", "LINKUSD", "XLMUSD", "AVAXUSD", "SUIUSD",
            "LTCUSD", "USDSUSD", "SHIBUSD", "TONUSD", "BCHUSD", "OMUSD"
    );

    public Map<String, Object> fetchCryptoData() {
        //List<CryptoCurrencyDTO> cryptoList = new ArrayList<>();

        String url = BASE_API_URL + String.join(",", TOP_CURRENCIES);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        if (response != null && response.containsKey("result")) {
            Map<String, Object> result = (Map<String, Object>) response.get("result");

            result.forEach((pair, data) -> {
                Map<String, Object> dataMap = (Map<String, Object>) data;
                double price = Double.parseDouble(((List<String>) dataMap.get("c")).get(0));
                cryptoList.put(pair, price);
            });
        }
        return cryptoList;
    }

    public String buyCrypto(String symbol, double amount) {
        if(amount < 1 ){
            return "The quantity should be 1 or more.";
        }


        Double price = (Double) cryptoList.get(symbol);
        if (price == null) {
            return "Invalid symbol or price not available.";
        }
        double cost = amount * price;
        if (userDto.getBalance() < cost) {
            return "Insufficient balance.";
        }
        userDto.setBalance(userDto.getBalance() - cost);
        userDto.addTransaction(symbol, amount, cost, CryptoAction.BUY);

        return "Successfully bought " + amount + " " + symbol + " for " + cost + " USD.";
    }

    public double getBalance() {
        return userDto.getBalance();
    }

    public String sellCrypto(String symbol, double amount) {
        if(amount < 1 ){
            return "The quantity should be 1 or more.";
        }

        Double price = (Double) cryptoList.get(symbol);
        if (price == null) {
            return "Invalid transaction";
        }
        double revenue = amount * price;
        if (userDto.getBalance() < revenue) {
            return "Insufficient balance.";
        }
        userDto.setBalance(userDto.getBalance() - revenue);
        userDto.addTransaction(symbol, amount, revenue, CryptoAction.SELL);

        return "Successfully sold " + amount + " " + symbol + " for " + revenue + " USD.";
    }


    public String resetBalance(){
        userDto.setDefaultBalance();
        userDto.setTransactionDTOS();

        return "Balance reset to default.";
    }

    public List<TransactionDTO> getTransactions(){
        return userDto.getTransactionDTOS();
    }
}

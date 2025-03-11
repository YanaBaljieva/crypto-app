package com.example.demo.controllers;

//import com.example.demo.dto.CryptoCurrencyDTO;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.services.CryptoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.List;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/")
public class TradingController {
    @Autowired
    private final CryptoService cryptoService;

    public TradingController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @PostConstruct
    @GetMapping("/crypto")
    public Map<String, Object> getAllCrypto() {
        return cryptoService.fetchCryptoData();
    }


    @GetMapping("/balance")
    public double getBalance() {
        return cryptoService.getBalance();
    }

    @PostMapping("/buy")
    public String buyCrypto(@RequestParam String symbol, @RequestParam double amount) {
        return cryptoService.buyCrypto(symbol, amount);
    }

    @PostMapping("/sell")
    public String sellCrypto(@RequestParam String symbol, @RequestParam double amount) {
        return cryptoService.sellCrypto(symbol, amount);
    }

    @GetMapping("/transactions")
    public List<TransactionDTO> getTransactions() {
        return cryptoService.getTransactions();
    }


    @PostMapping("/reset")
    public String resetBalance() {
        return cryptoService.resetBalance();
    }


     /*

    @GetMapping
    public Map<CryptoCurrencyDTO> getAllCrypto() {
        return service.fetchCryptoData();
    }

    */

}

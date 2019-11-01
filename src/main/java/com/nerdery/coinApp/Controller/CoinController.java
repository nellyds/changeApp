package com.nerdery.coinApp.Controller;

import com.nerdery.coinApp.Service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CoinController {

    @Autowired
    CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService){
        this.coinService = coinService;
    }

    @GetMapping("/api")
    public ResponseEntity<HashMap<String,Integer>> getFewestCoinsHeadless(@RequestParam (value = "dollarValue") String dollarValue){
        HashMap<String,Integer> result = coinService.findAndSortFewestCoins(dollarValue);
        return ResponseEntity.ok(result);
    }
}




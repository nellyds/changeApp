package com.nerdery.coinApp.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nerdery.coinApp.Models.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.nerdery.coinApp.Util.CoinUtil.generateCurrencyList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinServiceTest {

    @Autowired
    private CoinService coinService;

    @Test
    public void findFewestCoinsTest() {
        org.junit.Assert.assertEquals(6, coinService.findFewestCoins(BigDecimal.valueOf(.39)).size());
        org.junit.Assert.assertEquals(5, coinService.findFewestCoins(BigDecimal.valueOf(5)).size());
        org.junit.Assert.assertEquals(1, coinService.findFewestCoins(BigDecimal.valueOf(.01)).size());
        org.junit.Assert.assertEquals(0, coinService.findFewestCoins(BigDecimal.valueOf(.0001)).size());
        org.junit.Assert.assertEquals(0, coinService.findFewestCoins(BigDecimal.valueOf(-3)).size());
    }

    @Test
    public void sortCointest(){
        org.junit.Assert.assertEquals(validResult(),coinService.sortFewestCoins(validList()) );
    }

    @Test
    public void sortFewestCoinsTest(){
        org.junit.Assert.assertEquals(badResult(), coinService.findAndSortFewestCoins("-3"));
        org.junit.Assert.assertEquals(validResult(), coinService.findAndSortFewestCoins("1.28"));
        org.junit.Assert.assertEquals(highResult(), coinService.findAndSortFewestCoins("50.01"));
    }

    private static HashMap<String, Integer> badResult(){
        HashMap<String, Integer> badResult = new HashMap<>();
        for (AbstractCurrency item : generateCurrencyList()) {
            badResult.put(item.getName(), 0);
        }
        return badResult;
    }

    private static List<AbstractCurrency> validList(){
        Penny penny = new Penny();
        Quarter quarter = new Quarter();
        SilverDollar dollar = new SilverDollar();
        return Arrays.asList(dollar, quarter, penny, penny, penny);
    }
    private static HashMap<String, Integer> validResult(){
        HashMap<String, Integer> validResult = new HashMap<>();
        validResult.put("Quarter",1);
        validResult.put("Dime",0);
        validResult.put("Penny",3);
        validResult.put("Half Dollar", 0);
        validResult.put("Nickel", 0);
        validResult.put("Silver Dollar", 1);
        return validResult;
    }

    private static HashMap<String, Integer> highResult(){
        HashMap<String, Integer> highResult = new HashMap<>();
        highResult.put("Quarter",0);
        highResult.put("Dime",0);
        highResult.put("Penny",1);
        highResult.put("Half Dollar", 0);
        highResult.put("Nickel", 0);
        highResult.put("Silver Dollar", 50);
        return highResult;
    }

}

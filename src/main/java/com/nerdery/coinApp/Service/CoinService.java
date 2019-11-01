package com.nerdery.coinApp.Service;

import com.nerdery.coinApp.Models.AbstractCurrency;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nerdery.coinApp.Util.CoinUtil.*;

@Service
public class CoinService {

    public HashMap<String, Integer> findAndSortFewestCoins(String dollarValue) {
        if (bigDecimalStringValidate(dollarValue)) {
            BigDecimal value = new BigDecimal(dollarValue);
            List<AbstractCurrency> fewestCoins = findFewestCoins(value);
            HashMap<String, Integer> sortFewestCoins = sortFewestCoins(fewestCoins);
            return sortFewestCoins;
        }
        return emptyResultMap();

    }


    public List<AbstractCurrency> findFewestCoins(BigDecimal total) {
        List<AbstractCurrency> fewestCoins = new ArrayList<>();
            while (total.compareTo(BigDecimal.ZERO)> 0) {
                if (total.compareTo(BigDecimal.valueOf(.01)) >= 0) {
                    List<AbstractCurrency> coins = generateCurrencyList();
                    for (int i = 0; i < coins.size(); i++) {
                        while (total.compareTo(BigDecimal.valueOf(coins.get(i).getCents())) >= 0) {
                            total = total.subtract(BigDecimal.valueOf(coins.get(i).getCents()));
                            fewestCoins.add(coins.get(i));
                        }
                    }
                }
            }
        return fewestCoins;
    }

    public HashMap<String, Integer> sortFewestCoins(List<AbstractCurrency> fewestCoins) {
        HashMap<String, Integer> resultMap = emptyResultMap();
        for (AbstractCurrency coin : fewestCoins) {
            for (Map.Entry coinType : resultMap.entrySet()) {
                if (coin.getName().equals(coinType.getKey().toString())) {
                    coinType.setValue((Integer) coinType.getValue() + 1);
                }
            }
        }
        return resultMap;
    }
}



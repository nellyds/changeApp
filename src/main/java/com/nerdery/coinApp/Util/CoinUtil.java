package com.nerdery.coinApp.Util;

import com.nerdery.coinApp.Models.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class CoinUtil {

        public static HashMap<String, Integer> emptyResultMap(){
            HashMap<String, Integer> map = new HashMap<>();
            for (AbstractCurrency item : generateCurrencyList()) {
                map.put(item.getName(), 0);
            }
            return map;
    }

    public static List<AbstractCurrency> generateCurrencyList() {
        return Arrays.asList(new SilverDollar(), new HalfDollar(), new Quarter(), new Dime(), new Nickel(), new Penny());
    }

    public static boolean bigDecimalStringValidate(String dollarValue){
        String regex = "^\\d*\\.\\d+|\\d+\\.\\d*$";
        if (dollarValue.matches(regex)){
            return true;
        }
        return false;
    }
}

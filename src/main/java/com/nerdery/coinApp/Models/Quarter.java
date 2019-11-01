package com.nerdery.coinApp.Models;

import java.math.BigDecimal;

public class Quarter extends AbstractCurrency implements CoinInterface{

    private double cents;
    private String name;

    @Override
    public double getCents() {
        return .25;
    }

    @Override
    public String getName() {
        return "Quarter";
    }

}

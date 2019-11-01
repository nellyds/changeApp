package com.nerdery.coinApp.Models;

public class Penny extends AbstractCurrency implements CoinInterface {

    private double cents;
    private String name;

    @Override
    public double getCents() {
        return .01;
    }

    @Override
    public String getName() {
        return "Penny";
    }

}

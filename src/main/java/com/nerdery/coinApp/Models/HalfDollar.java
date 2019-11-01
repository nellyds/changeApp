package com.nerdery.coinApp.Models;

public class HalfDollar extends AbstractCurrency implements CoinInterface {

    private double cents;
    private String name;

    @Override
    public double getCents() {
        return .50;
    }

    @Override
    public String getName() {
        return "Half Dollar";
    }

}
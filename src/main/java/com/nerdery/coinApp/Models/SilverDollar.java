package com.nerdery.coinApp.Models;

public class SilverDollar extends AbstractCurrency implements CoinInterface {

    private double cents;
    private String name;

    @Override
    public double getCents() {
        return 1.00;
    }

    @Override
    public String getName() {
        return "Silver Dollar";
    }

}

package com.nerdery.coinApp.Models;

public class Nickel extends AbstractCurrency implements CoinInterface {

    private double cents;
    private String name;

    @Override
    public double getCents() {
        return .05;
    }


    @Override
    public String getName() {
        return "Nickel";
    }

}

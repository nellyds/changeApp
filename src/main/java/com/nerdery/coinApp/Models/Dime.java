package com.nerdery.coinApp.Models;

public class Dime extends AbstractCurrency implements CoinInterface {

    private double cents;
    private String name;

    @Override
    public double getCents() {
        return .10;
    }


    @Override
    public String getName() {
        return "Dime";
    }


}

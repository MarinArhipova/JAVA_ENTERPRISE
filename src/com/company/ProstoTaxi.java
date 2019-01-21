package com.company;

public class ProstoTaxi implements Taxi {
    @Override
    public double price(double km) {
        return 20*km;
    }
}

package com.company;

public class TheBestTaxi implements Taxi {
    private final double promoKod = 0.5;

    private double km;
    private Check check;

    public TheBestTaxi(double km, Check check){
        this.km=km;
        this.check=check;
    }


    @Override
    public double price(double km) {
//        if (kod == "qwerty007") return 20*km*0.5;
//        else throw new IllegalArgumentException("Promotional code is not valid");

        return 20*km*promoKod;
    }
}

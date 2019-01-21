package com.company;

public class SuicideTaxi implements Taxi {
    private double km;
    private Check check;

    public SuicideTaxi(double km, Check check){
        this.km=km;
        this.check=check;
    }
    @Override
    public double price(double km) {
        if (20*km>100) {
            System.out.println("Спасибо, что живой!");
            return 5000;
        }
        else return 20*km;
    }


}

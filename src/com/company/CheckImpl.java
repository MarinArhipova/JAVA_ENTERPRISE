package com.company;

public class CheckImpl implements Check{
    @Override
    public void print(double km, double sum) {
        System.err.println(" Вы проехали : " + km + "км. К оплате :" + sum + "рублей.");
    }
}

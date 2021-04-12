package sk.kosickaakademia.matolak.exchangerate;

import sk.kosickaakademia.matolak.exchangerate.calc.Calc;

import java.util.HashSet;
import java.util.Set;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println("=================================");
        System.out.println("Welcome to the Exchange Rates App");
        System.out.println("=================================");
        Set<String> set = new HashSet<>();
        set.add("USD");
        set.add("HUF");
        set.add("CZK");
        set.add("BTC");

        Calc calcExchangeRates = new Calc();
        calcExchangeRates.calculate(100);

    }
}

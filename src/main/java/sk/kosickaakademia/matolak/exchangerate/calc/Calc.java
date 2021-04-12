package sk.kosickaakademia.matolak.exchangerate.calc;

import sk.kosickaakademia.matolak.exchangerate.api.Api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Calc {
    private static final String[] rates= new String[]{"USD","CZK","HUF","BTC","PLN"};

    public void calculate(double eur){
        if(eur<0){
            System.out.println("Input cannot be a negative value!");
            return;
        }
        Set<String> set = new HashSet<>();
        Collections.addAll(set, rates);

        // zavolame metodu getExchangeRates, ktora nam posle vsetky kurzy, ktore pozadujeme
        Api api=new Api();
        Map map = api.getExchangeRates(set);

        // prechadzame polom pozadovanych mien , pre ktore robime konverziu
        for(String temp:rates){
            // ak dana mena sa nasla a mame aj kurz, robime prepocet
            if(map.containsKey(temp)){  // temp ... skratka meny, na ktoru robime prevod
                double value = (double)map.get(temp);  // vymenny kurz
                double result = eur*value;   // prepocitany vysledok

                // volame pomocnu metodu ktora vypisuje vysledok
                print("EUR",temp, eur, result, value);
            }
        }
    }

    // pomocna metoda, sluzi na vypis vysledkov
    // vypisujeme aj detaily
    private void print(String from, String to, double eur, double result, double rate){
        System.out.println(eur +" "+from+" -> "+result+" "+to+" (exchange rate: "+rate+" )");
    }
}

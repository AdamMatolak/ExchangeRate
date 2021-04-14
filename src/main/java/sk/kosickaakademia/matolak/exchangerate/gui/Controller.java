package sk.kosickaakademia.matolak.exchangerate.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import sk.kosickaakademia.matolak.exchangerate.calc.Calc;

public class Controller {
    private static final String[] currency= new String[]{"USD","CZK","GBP","PLN"};
    private Button btn_exchange;
    private TextField txt_eur;
    private ListView classic;
    public TextField txt_usd;
    public TextField txt_czk;
    public TextField txt_gbp;
    public TextField txt_pln;


    public void exchange(ActionEvent actionEvent) {
        Calc calc=new Calc();
        String base_currency=txt_eur.getText();
        if (base_currency.isEmpty()){
            return;
        }
        double base_currency_eur=Double.parseDouble(base_currency);
        calc.calculate(base_currency_eur,currency);
    }
}

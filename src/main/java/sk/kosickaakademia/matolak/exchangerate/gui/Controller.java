package sk.kosickaakademia.matolak.exchangerate.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sk.kosickaakademia.matolak.exchangerate.calc.Calc;

import java.text.DecimalFormat;
import java.util.Map;

public class Controller {
    private static final String[] currency= new String[]{"USD","CZK","GBP","PLN"};
    private Button btn_exchange;
    private TextField txt_eur;
    private ListView classic;
    public TextField txt_usd;
    public TextField txt_czk;
    public TextField txt_gbp;
    public TextField txt_pln;
    public TextField txt_btc;

    public void exchange(ActionEvent actionEvent) {
        String value = txt_eur.getText();
        double valueEur=Double.parseDouble(value);
        Calc calc=new Calc();
        Map results = calc.calculate(valueEur,currency);
        txt_czk.setText(convertTo2Decimal((double)results.get("CZK")));
        txt_gbp.setText(convertTo2Decimal((double)results.get("HRK")));
        txt_pln.setText(convertTo2Decimal((double)results.get("UAH")));
        txt_usd.setText(convertTo2Decimal((double)results.get("PLN")));
        txt_btc.setText(results.get("BTC").toString());
        double base_currency_eur=Double.parseDouble(value);
        calc.calculate(base_currency_eur,currency);
    }
    private String convertTo2Decimal(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        String angleFormated = df.format(value);
        return angleFormated;
    }
}

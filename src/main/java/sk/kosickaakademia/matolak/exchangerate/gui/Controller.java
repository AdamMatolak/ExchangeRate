package sk.kosickaakademia.matolak.exchangerate.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sk.kosickaakademia.matolak.exchangerate.calc.Calc;

import java.text.DecimalFormat;
import java.util.Map;

public class Controller {
    Calc calc=new Calc();
    private static final String[] currency= new String[]{"USD","CZK","GBP","PLN","BTC"};
    @FXML
    private Button btn_exchange;
    @FXML
    private TextField txt_eur;
    private ListView classic;
    public TextField txt_usd;
    public TextField txt_czk;
    public TextField txt_gbp;
    public TextField txt_pln;
    public TextField txt_btc;

    public void exchange(ActionEvent actionEvent) {
        try{
            String value = txt_eur.getText();
            double valueEur=Double.parseDouble(value);
            if (valueEur<=0){
                txt_czk.clear();
                txt_gbp.clear();
                txt_pln.clear();
                txt_usd.clear();
                txt_btc.clear();
            }else {
                Map results = calc.calculate(valueEur,currency);
                txt_czk.setText(convertTo2Decimal((double)results.get("CZK")));
                txt_gbp.setText(convertTo2Decimal((double)results.get("GBP")));
                txt_pln.setText(convertTo2Decimal((double)results.get("PLN")));
                txt_usd.setText(convertTo2Decimal((double)results.get("USD")));
                txt_btc.setText(results.get("BTC").toString());
                double base_currency_eur=Double.parseDouble(value);
                calc.calculate(base_currency_eur,currency);
            }
        }catch (NumberFormatException ex){
            txt_czk.clear();
            txt_gbp.clear();
            txt_pln.clear();
            txt_usd.clear();
            txt_btc.clear();
        }
    }
    private String convertTo2Decimal(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        String angleFormated = df.format(value);
        return angleFormated;
    }
}

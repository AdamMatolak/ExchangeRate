package sk.kosickaakademia.matolak.exchangerate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sk.kosickaakademia.matolak.exchangerate.api.Api;
import sk.kosickaakademia.matolak.exchangerate.calc.Calc;
import sk.kosickaakademia.matolak.exchangerate.database.MongoDb;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main extends Application
{
    public static void main( String[] args )
    {
        /*System.out.println("=================================");
        System.out.println("Welcome to the Exchange Rates App");
        System.out.println("=================================");
        Set<String> set = new HashSet<>();
        set.add("USD");
        set.add("HUF");
        set.add("CZK");
        set.add("BTC");

        Calc calcExchangeRates = new Calc();
        calcExchangeRates.calculate(100);
        launch(Main.class, (java.lang.String)null);*/

        launch(args);
        MongoDb database=new MongoDb();
        database.test();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/java/sk/kosickaakademia/matolak/exchangerate/gui/Gui.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        primaryStage.setTitle("Currency Exchange convertor V 1.0");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}

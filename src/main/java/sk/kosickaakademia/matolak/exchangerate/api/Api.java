package sk.kosickaakademia.matolak.exchangerate.api;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Api {
    private static final String key  = "fd9c63f568efa05da69ac8f7d028cee8";

    public Map getExchangeRates(Set<String> rates){
        if(rates==null || rates.size() ==0)
            return null;
        return parseData(rates);
    }
    private String getRatesFromAPIServer(){
        try {
            URL url = new URL("http://api.exchangeratesapi.io/v1/latest?access_key="+key+"&format=1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();
                return inline;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Map parseData(Set<String> rates){

        String inline=getRatesFromAPIServer();

        if(inline==null)
            return null;
        try {
            JSONParser parse = new JSONParser();
            JSONObject dataObj = (JSONObject)parse.parse(inline);
            JSONObject obj = (JSONObject) dataObj.get("rates");
            Map<String,Double> maps = new HashMap<>();

            for(String temp:rates){
                if(obj.containsKey(temp)){
                    double value= (double)obj.get(temp);
                    maps.put(temp,value);
                }
            }
            return maps;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}

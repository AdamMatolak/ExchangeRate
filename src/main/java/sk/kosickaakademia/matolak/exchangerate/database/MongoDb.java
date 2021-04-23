package sk.kosickaakademia.matolak.exchangerate.database;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.List;
import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class MongoDb {
    MongoClient client = MongoClients.create();
    private static MongoDatabase database;
    private static Document docs;
    private static MongoCollection<Document> collection;
    private Date date=new Date();

    public void insertExchangeHistory(double value, String[] to){
        database=client.getDatabase("ExchangeDB");
        collection = database.getCollection("ExchangeHistory");
        List<String> list = Arrays.asList(to.clone());
        docs=new Document("date",date.toString())
                .append("value",value)
                .append("rates", list);
        collection.insertOne(docs);
    }

    public void test(){
        MongoDatabase database = client.getDatabase("test");
        MongoCollection<Document> toys = database.getCollection("cars");
        Document toy = new Document("name", "yoyo").append("ages", new Document("min", 5));
        toys.insertOne(toy);
    }
}

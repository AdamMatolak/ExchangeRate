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

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class MongoDb {
    MongoClient client = MongoClients.create();

    MongoDatabase database = client.getDatabase("test");
    MongoCollection<Document> toys = database.getCollection("cars");
}

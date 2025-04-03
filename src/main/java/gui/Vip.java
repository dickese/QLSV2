package gui;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Vip {
	public static void main(String[] args) {
		String url = "mongodb://localhost:27017";
		String dbName = "23704871";
		MongoClient client = MongoClients.create(url);
		MongoDatabase db  = client.getDatabase(dbName);
		new DangNhap(db);
	}
}
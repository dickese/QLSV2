package dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import pojo.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private MongoCollection<Document> collection;

    public AccountDAO(MongoCollection<Document> coll) {
        collection = coll;
    }

    public void addAccounts(Account accounts) {
        Document doc = new Document()
                .append("username", accounts.getUsername())
                .append("password", accounts.getPassword())
                .append("role", accounts.getRole());
        collection.insertOne(doc);

    }

    public List<Account> getAllAccounts(){
        List<Account> accList = new ArrayList<>();
        for(Document doc:collection.find()) {
            accList.add(new Account(
                    doc.getObjectId("_id").toString(),
                    doc.getString("username"),
                    doc.getString("password"),
                    Integer.parseInt(doc.getString("role"))
            ));
        }
        return accList;
    }

    public void updateAccounts(String id, String username, String password, int role) {
        collection.updateOne(Filters.eq("_id", id),
                Updates.combine(
                        Updates.set("username", username),
                        Updates.set("password", password),
                        Updates.set("role", role)
                ));
    }

    public boolean checkLogIn(String userName, String pwd){
        Document user = collection.find(new Document("username", userName)
                .append("password", pwd)).first();
        return user != null;
    }

    public void deleteAccounts(String userName, String pwd) {
        Document filter = new Document("username", userName).append("password", pwd);
        collection.deleteOne(filter);
    }

//    public void closeConnection() {
//        mongoClient.close();
//    }
}

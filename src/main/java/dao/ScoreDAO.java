package dao;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import pojo.Score;
import utils.Utils;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.inc;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ScoreDAO {
    private final MongoCollection<Document> collection;
    private final MongoCollection<Document> counters;
    public ScoreDAO(MongoDatabase db) {
        this.collection = db.getCollection("scores");
        this.counters = db.getCollection("counters");
    }

    public List<Score> getAll(){
        FindIterable<Document> documents = collection.find();
        return Utils.mapperDocListToScoreList(documents);
    }

    public String addScore(Score score) {
        Document counter = counters.findOneAndUpdate(
                eq("_id", "SC"),
                inc("lastValue", 1)
        );
        if (counter == null) {
            counters.insertOne(new Document("_id", "SC").append("lastValue", 39));
            counter = (Document) counters.find(eq("_id", "SC"));
        }

        int newIdValue = counter.getInteger("lastValue");
        String newId = "SC" + newIdValue;

        checkEnroll(score.getEnrollId());
        Document doc = new Document("_id",newId)
                .append("student_id", score.getStudentId())
                .append("subject_id", score.getSubjectId())
                .append("class_id", score.getClassId())
                .append("enroll_id", score.getEnrollId())
                .append("regularPoint", score.getRegularPoint())
                .append("midterm", score.getMidterm())
                .append("finalPoint", score.getFinalPoint())
                .append("finalScore", score.getFinalScore());
        collection.insertOne(doc);
        return newId;
    }


    public void deleteScore(String id) {
        long res = collection.deleteOne(new Document("_id", id)).getDeletedCount();
        if(res > 0){
            Document counter = counters.findOneAndUpdate(
                    eq("_id", "SC"),
                    inc("lastValue", -res)
            );
            if (counter == null) {
                counters.insertOne(new Document("_id", "SC").append("lastValue", 0));
            }
        }
    }


    public void updateScore(String id, Score score) {
        collection.updateOne(Filters.eq("_id", id),
                Updates.combine(
                        Updates.set("student_id", score.getStudentId()),
                        Updates.set("subject_id", score.getSubjectId()),
                        Updates.set("enroll_id", score.getEnrollId()),
                        Updates.set("class_id", score.getClassId()),
                        Updates.set("regularPoint", score.getRegularPoint()),
                        Updates.set("midterm", score.getMidterm()),
                        Updates.set("finalPoint", score.getFinalPoint()),
                        Updates.set("finalScore", score.getFinalScore())
                ));
    }

    public void importFile(File inputfile){
        List<Score> newDS = Utils.readFile(inputfile);
        assert newDS != null;
        for(Score s : newDS){
            this.addScore(s);
        }
    }


    public void checkEnroll(String enrollID){
        Bson lookupStage = lookup("enrollments", "enroll_id", "_id", "enrollment_info");
        Bson matchStage = match(eq("enroll_id", enrollID));
        Document result =  collection.aggregate(Arrays.asList(matchStage, lookupStage)).first();
//        if(result.get("enrollment_info")){
//            throw new IllegalArgumentException("Không tìm thấy mã đăng ký học phần");
//        }
    }

    public static void main(String[] args) {
        MongoClient sc = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase md = sc.getDatabase("23704871");
//        MongoCollection<Document> coll = md.getCollection("scores");
        ScoreDAO dao = new ScoreDAO(md);
//        List<Score> sr = dao.getAll();
//        for(Score s : sr){
//            System.out.println(s.toString());
//        }
//        Score news = new Score("SV001", "SUB002", "CL001", "ENR002", Arrays.asList( 6.8, 7.5, 8.0), 7.5,8.2);
//        String id = dao.addScore(news);
//        news.setId(id);
        dao.deleteScore("SC40");
    }
}

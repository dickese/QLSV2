package dao;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import pojo.Score;

public class ScoreDAO {
    private final MongoCollection<Document> collection;

    public ScoreDAO(MongoCollection<Document> collections) {
        this.collection = collections;
    }
    public void addScore(Score score) {
        Document doc = new Document("studentId", score.getStudentId())
                .append("subjectID", score.getSubjectId())
                .append("regularPoint", score.getRegularPoint().toArray())
                .append("midterm", score.getMidterm())
                .append("finalPoint", score.getFinalPoint())
                .append("finalScore", score.getFinalScore());
        collection.insertOne(doc);
    }
    public void deleteEnroll(String id) {
        collection.deleteOne(new Document("_id", id));
    }
    public void updateScore(String id, Score score) {
        collection.updateOne(
                new Document("studentId", id),
                new Document("$set", new Document("studentId", score.getStudentId())
                        .append("subjectID", score.getSubjectId())
                        .append("regularPoint", score.getRegularPoint().toArray())
                        .append("midterm", score.getMidterm())
                        .append("finalPoint", score.getFinalPoint())
                        .append("finalScore", score.getFinalScore()))
        );
    }

    
}

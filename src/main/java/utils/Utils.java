package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import pojo.Score;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Score> readFile(File inputFile){
        if(inputFile == null){
            throw new IllegalArgumentException("Không có file");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(inputFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Score> mapperDocListToScoreList(FindIterable<Document> docs){
        List<Score> scores = new ArrayList<>();

        for (Document doc : docs) {
            Score score = new Score();
            score.setId(doc.getString("_id"));
            score.setEnrollId(doc.getString("enroll_id"));
            score.setStudentId(doc.getString("student_id"));
            score.setSubjectId(doc.getString("subject_id"));
            score.setClassId(doc.getString("class_id"));

            List<Double> regularPointList = new ArrayList<>();
            List<?> regularPointFromDoc = doc.getList("regularPoint", Object.class);
            if (regularPointFromDoc != null) {
                for (Object point : regularPointFromDoc) {
                    if (point instanceof Number) {
                        regularPointList.add(((Number) point).doubleValue());
                    }
                }
            }
            score.setRegularPoint(regularPointList);

            score.setMidterm(doc.getDouble("midterm"));
            score.setMidterm(doc.getDouble("finalPoint"));
            score.setMidterm(doc.getDouble("finalScore"));

            scores.add(score);
        }
        return scores;
    }

}

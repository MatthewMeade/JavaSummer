import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Question {

    public static String EASY = "easy";
    public static String MEDIUM = "medium";
    public static String HARD = "hard";


    private String questionText;
    private String[] answers;
    private int correct;

    public Question(String questionText, String[] answers, int correct) {
        this.questionText = questionText;
        this.answers = answers;
        this.correct = correct;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getAnswers() {
        return answers;
    }

    public boolean CheckAnswer(int choice){
        return choice == correct;
    }

}

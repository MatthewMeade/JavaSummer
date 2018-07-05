import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class QuestionManager {

    // TODO store difficulties in a single dictionary
    private ArrayList<Question> easyArr = new ArrayList<>();
    private ArrayList<Question> mediumArr = new ArrayList<>();
    private ArrayList<Question> hardArr = new ArrayList<>();

    private JSONObject json;

    public QuestionManager() {
        json = LoadJson();
        populateDifficulty(Question.EASY, easyArr);
        populateDifficulty(Question.MEDIUM, mediumArr);
        populateDifficulty(Question.HARD, hardArr);
    }

    public Question getQuestion(String difficulty) {
        ArrayList<Question> selectedList;

        if (difficulty.equals(Question.EASY)) selectedList = easyArr;
        else if (difficulty.equals(Question.EASY)) selectedList = mediumArr;
        else if (difficulty.equals(Question.EASY)) selectedList = hardArr;
        else selectedList = mediumArr;

        if (selectedList.size() == 0) {
            populateDifficulty(difficulty, selectedList);
        }

        return selectedList.remove(0);
    }

    private JSONObject LoadJson(){
        JSONObject obj;
        try {
            obj = (JSONObject) new JSONParser().parse(new FileReader("files/questions.json"));
        } catch (IOException e) {
            System.err.println("Could not open questions.json");
            return null;
        } catch (ParseException e) {
            System.err.println("Could not parse questions.json");
            return null;
        }

        return obj;

    }

    private void populateDifficulty(String diffName, ArrayList list){
        JSONArray obj = (JSONArray) json.get(diffName);

        for (int i = 0; i <  obj.size(); i++) {
            JSONObject question = (JSONObject) obj.get(i);
            String questionText = (String) question.get("question");
            int correct = (int) (long) question.get("correct");

            JSONArray answersObj = (JSONArray) question.get("answers");

            String[] answers = new String[]{(String) answersObj.get(0), (String) answersObj.get(1), (String) answersObj.get(2)};

            list.add(new Question(questionText, answers, correct));
        }
        Collections.shuffle(list);
    }
}

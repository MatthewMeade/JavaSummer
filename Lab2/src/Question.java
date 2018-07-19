import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Class representing a randomly generated math question of varying difficulty
 */
public class Question {
    private String questionText;
    private String[] answers = new String[3];
    private int correct;

    private Random random = new Random();

    public static final String EASY = "Easy";
    public static final String MEDIUM = "Medium";
    public static final String HARD = "Hard";

    // Possible base expression templates
    private static final ArrayList<String> questionTemplate = new ArrayList<>(Arrays.asList(
            "%s + %s", "%s - %s", "%s * %s", "%s / %s"
    ));

    /**
     * Constructs a question given a difficulty
     * @param difficulty String difficulty of question "easy" "medium" "hard"
     */
    public Question(String difficulty) throws Exception {
        // Generate question string
        if (difficulty.equals(Question.EASY)) {
            questionText = generateQuestion();
        } else if (difficulty.equals(Question.MEDIUM)) {
            questionText = generateQuestion(generateQuestion());
        } else {
            questionText = generateQuestion(generateQuestion(), generateQuestion());
        }

        // Evaluate question string
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        double correctAnswer = Double.parseDouble(engine.eval(questionText).toString());

        // Populate answer array with incorrect answers generated from the correct answer

        for (int i = 0; i < answers.length; i++) {
            answers[i] = formatAnswer(randomAnswer(correctAnswer));
        }

        // Select correct answer index and insert correct answer into array
        correct = random.nextInt(3);
        answers[correct] = formatAnswer(correctAnswer);
    }

    /**
     * Given a correct answer, generates another possible answer around the same value
     * @param correctAnswer double correct answer to use as base when generating incorrect answer
     * @return double generated incorrect answer
     */
    private double randomAnswer(double correctAnswer) {

        double newAnswer;
        do { // Ensure new answer is not equal to the correct answer

            // Don't add decimal values if correct answer is a whole number
            if (correctAnswer == Math.floor(correctAnswer)) {
                newAnswer = random.nextBoolean() ?
                        correctAnswer + random.nextInt(Math.abs((int) Math.round(correctAnswer * 0.25))) :
                        correctAnswer - random.nextInt(Math.abs((int) Math.round(correctAnswer * 0.25)));
            } else {
                newAnswer = correctAnswer * random.nextDouble() * 2;
            }
        } while (newAnswer == correctAnswer);

        return newAnswer;

    }

    /**
     * Generates an expression in the form "a [random operator] b"
     * @param a String expression left hand side
     * @param b String expression right hand side
     * @return String generated expression
     */
    private String generateQuestion(String a, String b) {
        Collections.shuffle(questionTemplate);
        return String.format(questionTemplate.get(0), a, b);
    }

    /**
     * Generates an express in the form "a [random operator] [random expression]"
     * @param a String expression left hand side
     * @return String generated expression
     */
    private String generateQuestion(String a) {
        Collections.shuffle(questionTemplate);
        return String.format(questionTemplate.get(0), a, random.nextInt(25) + 1);
    }

    /***
     * Generates a random expression with random integers and a random operator
     * @return String generated expression
     */
    private String generateQuestion() {
        Collections.shuffle(questionTemplate);
        return String.format(questionTemplate.get(0), random.nextInt(25) + 1, random.nextInt(25) + 1);
    }

    /**
     * Formats a decimal to four decimal places or zero decimal places if whole number
     * @param answer double answer to be generated
     * @return string formatted string
     */
    private String formatAnswer(double answer) {
        if (Math.floor(answer) == answer) {
            return String.format("%.0f", answer);
        } else {
            return String.format("%.4f", answer);
        }
    }

    /**
     * Returns question expression
     * @return String expression
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Returns array of possible answers
     * @return String[] answer array
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * Given a choice index returns true if index matches index of correct answer
     * @param choice integer index of chosen answer
     * @return boolean true if choice is correct
     */
    public boolean CheckAnswer(int choice) {
        return choice == correct;
    }

}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Main class for math quiz app
 */
public class QuizApp {

    private static Question currentQuestion;
    private static GameFrame gameFrame;
    private static String difficulty = Question.MEDIUM;

    /**
     * Starts the game
     * @param args none
     */
    public static void main(String[] args){

        // Set up game frame
        gameFrame = new GameFrame(new ButtonHandler(), new RadioHandler());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(400,350);
        gameFrame.setVisible(true);

        // Start question loop
        nextQuestion();
    }

    /**
     * Generates a new question and updates game frame
     */
    private static void nextQuestion(){
        try {
            currentQuestion = new Question(difficulty);
            gameFrame.updateUI(currentQuestion);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }

    /**
     * Button click event handler class
     */
    private static class ButtonHandler implements ActionListener {
        /**
         * Handles a button click
         * Determines which button was clicked and notifies user if the choice was correct
         * @param e ActionEvent Button click event
         */
        public void actionPerformed(ActionEvent e) {
            int clickedButton = Integer.parseInt(((JButton) e.getSource()).getName());
            JOptionPane.showMessageDialog(null, currentQuestion.CheckAnswer(clickedButton) ? "Correct!" : "Incorrect");
            nextQuestion();
        }
    }

    /**
     * Radio button event handler class
     */
    private static class RadioHandler implements ItemListener {
        /**
         * Changes the game difficulty based on which difficulty was selected and generates new question
         * @param e ItemEvent radio button click event
         */
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                difficulty = ((JRadioButton)e.getSource()).getName();
                nextQuestion();
            }
        }
    }
}

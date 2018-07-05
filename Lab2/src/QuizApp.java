import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class QuizApp {

    private static QuestionManager questionManager = new QuestionManager();
    private static Question currentQuestion;
    private static GameFrame gameFrame;
    private static String difficulty = "medium";

    public static void main(String[] args){
        gameFrame = new GameFrame(new ButtonHandler(), new RadioHandler());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(400,350);
        gameFrame.setVisible(true);

        nextQuestion();
    }

    private static void nextQuestion(){
        currentQuestion = questionManager.getQuestion(difficulty);
        gameFrame.updateUI(currentQuestion);
    }

    private static class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int clickedButton = Integer.parseInt(((JButton) e.getSource()).getName());
            JOptionPane.showMessageDialog(null, currentQuestion.CheckAnswer(clickedButton) ? "Correct!" : "Incorrect");
            nextQuestion();
        }
    }

    private static class RadioHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == 1) {
                difficulty = ((JRadioButton)e.getSource()).getName();
                nextQuestion();
            }
        }
    }
}

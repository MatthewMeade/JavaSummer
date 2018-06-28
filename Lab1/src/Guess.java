import javax.swing.JOptionPane;
import java.util.Random;

/**
 * Class used to demonstrate usage of JOptionPane Dialogs
 */
public class Guess {

    /**
     * Prompts the user for an integer with a dialog until the correct guess is entered
     *
     * Assumes input is valid
     * @param args None
     */
    public static void main(String[] args){
        int correct = new Random().nextInt(10) + 1;
        int guesses = 0, guess = 0;

        while (guess != correct) {
            guess = Integer.parseInt(JOptionPane.showInputDialog("Enter your guess"));
            guesses++;
        }

        JOptionPane.showMessageDialog(null,
                String.format("Correct guess of %d in %d guesses!", guess, guesses),
                "Correct",
                JOptionPane.PLAIN_MESSAGE);
    }
}

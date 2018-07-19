import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/*
    Matching Game
    Click Matching Images
 */
public class MatchingGame {

    private static GameFrame gameFrame;

    /**
     * Game Startup
     * @param args none
     */
    public static void main(String[] args) {

        // Create Game Frame
        gameFrame = new GameFrame(new ButtonHandler());

        // Game Frame Setup
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(450,450);
        gameFrame.setVisible(true);
    }

    /**
     * Class used to handle button click and main game logic
     */
    private static class ButtonHandler implements ActionListener {
        /**
         * Method called when button was clicked
         * @param e ActionEvent event triggered by button click
         */
        public void actionPerformed(ActionEvent e) {
            // Set button to selected
            ((MatchingButton) e.getSource()).setSelected(true);

            // Grab all buttons set to Selected
            List<MatchingButton> selected = gameFrame.getSelected();

            // Test if user has selected enough buttons
            if (selected.size() == 2) {
                // Test if the clicked images match
                MatchingButton b1 = selected.get(0), b2 = selected.get(1);
                if (b1.matches(b2)) {
                    // Hide the image and display success
                    selected.forEach(b -> b.setVisible(false));
                    JOptionPane.showMessageDialog(gameFrame, "Success");
                } else {
                    // Deselect the image and display failure
                    selected.forEach(b -> b.setSelected(false));
                    JOptionPane.showMessageDialog(gameFrame, "Try Again");
                }

                // Test if game must be reset
                gameFrame.testGameOver();
            }
        }
    }
}

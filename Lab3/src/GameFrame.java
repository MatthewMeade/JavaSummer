import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Class used to display the game window and manage button collection
 */
public class GameFrame extends JFrame {

    private static ArrayList<MatchingButton> buttons;

    /**
     * Constructor
     * @param listener ActionListener to be applied to buttons
     */
    public GameFrame(ActionListener listener) {
        super("Matching Game");

        // Layout
        setLayout(new GridLayout(2, 2));

        // Button Creation
        buttons =new ArrayList<>(Arrays.asList(
                new MatchingButton("owl.png"), new MatchingButton("owl.png"),
                new MatchingButton("bulb.png"), new MatchingButton("bulb.png")
        ));

        // Assign listener to buttons
        buttons.forEach(b -> b.addActionListener(listener));

        // Start Game
        resetGame();
    }

    /**
     * Shuffles and resets state of buttons
     */
    public void resetGame(){
        Collections.shuffle(buttons);
        for (MatchingButton button : buttons)  {
            button.setSelected(false);
            button.setVisible(true);
            remove(button); // Remove from old position in grid
            add(button); // Add to new position in grid determined by location in collection
        }
    }

    /**
     * Returns buttons in the buttons collection that have their selected and visible properties set to true
     * @return ArrayList<MatchingButton> Collection of active selected buttons
     */
    public ArrayList<MatchingButton> getSelected() {
        return buttons.stream().filter(b -> b.isSelected() && b.isVisible()).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Tests if the user is out of buttons to click and resets the game
     */
    public void testGameOver() {
        int remaining =  buttons.stream().filter(b -> b.isVisible()).collect(Collectors.toCollection(ArrayList::new)).size();
        if (remaining == 0) {
            resetGame();
        }
    }
}

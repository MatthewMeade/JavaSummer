import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Class representing a button
 */
public class MatchingButton extends JButton {

    private String description;

    /**
     * Constructs a MatchingButton
     * @param imagePath String path to image to be displayed on button
     */
    public MatchingButton(String imagePath) {
        super();

        this.description = imagePath;

        try {
            setIcon(new ImageIcon(ImageIO.read(ClassLoader.getSystemResource(imagePath))));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Returns the description of the image
     * @return String image description
     */
    public String imageDescription() {
        return description;
    }

    /**
     * Returns true if given image description mates current image
     * @param otherButton
     * @return
     */
    public Boolean matches(MatchingButton otherButton){
        return description.equals(otherButton.imageDescription());
    }
}

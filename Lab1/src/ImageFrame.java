import javax.swing.*;
import java.awt.*;

public class ImageFrame extends JFrame {

    public ImageFrame() {
        super("Panel Demo");
        setLayout(new FlowLayout());
        JLabel label = new JLabel(new  ImageIcon(getClass().getResource("img.jpeg")));
        label.setToolTipText("Java Logo");
        add(label);
    }
}

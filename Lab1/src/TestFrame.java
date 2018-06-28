import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {

    public TestFrame() {
        super("Panel Demo");
        setLayout(new FlowLayout());
    }

    public void addLabel(int n) {
        JLabel label = new JLabel(String.format("Label %d", n));
        add(label);
    }
}

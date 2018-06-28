import javax.swing.*;

public class PrintLabels {
    public static void main(String[] args){
        TestFrame frame = new TestFrame();


        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter number of labels"));
        for (int i = 0; i < n; i++){
            frame.addLabel(i + 1);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(260, 180);
        frame.setVisible(true);
    }
}

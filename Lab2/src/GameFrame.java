import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;


public class GameFrame extends JFrame {

    private static String WINDOW_TITLE = "Quiz Game";

    private static String QUESTION_FORMAT = "<html><center>%s</center></html>";

    private JLabel questionLabel;
    private JButton[] answerButtons = new JButton[3];


    public GameFrame(ActionListener buttonHandler, ItemListener radioHandler) {
        super(WINDOW_TITLE);
        setLayout(new BorderLayout(5, 5));


        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        questionLabel.setBorder(new EmptyBorder(30, 10, 0, 10));
        add(questionLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.insets = new Insets(10, 0, 0, 0);

        for (int i = 0; i < answerButtons.length; i++) {
            constraints.gridy = i;
            answerButtons[i] = new JButton("");
            answerButtons[i].setPreferredSize(new Dimension(300, 30));
            answerButtons[i].setName("" + i);
            answerButtons[i].addActionListener(buttonHandler);
            centerPanel.add(answerButtons[i], constraints);
        }






        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton easyRadio = new JRadioButton("Easy", false);
        JRadioButton mediumRadio = new JRadioButton("Medium", true);
        JRadioButton hardRadio = new JRadioButton("Hard", false);

        easyRadio.setName("easy");
        mediumRadio.setName("medium");
        hardRadio.setName("hard");

        bottomPanel.add(easyRadio);
        bottomPanel.add(mediumRadio);
        bottomPanel.add(hardRadio);

        radioGroup.add(easyRadio);
        radioGroup.add(mediumRadio);
        radioGroup.add(hardRadio);


        easyRadio.addItemListener(radioHandler);
        mediumRadio.addItemListener(radioHandler);
        hardRadio.addItemListener(radioHandler);


        add(centerPanel, BorderLayout.CENTER);
        add(new JPanel(), BorderLayout.EAST);
        add(new JPanel(), BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void updateUI(Question question){
        questionLabel.setText(String.format(QUESTION_FORMAT, question.getQuestionText()));
        String[] answers = question.getAnswers();
        for (int i = 0; i < answers.length; i++){
            answerButtons[i].setText(answers[i]);
        }
    }





}

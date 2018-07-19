import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * Class representing quiz game user interface
 */
public class GameFrame extends JFrame {

    private static String WINDOW_TITLE = "Quiz Game";
    private static String QUESTION_FORMAT = "<html><center>%s</center></html>";

    private JLabel questionLabel;
    private JButton[] answerButtons = new JButton[3];
    private JRadioButton[] difficultyButtons = new JRadioButton[3];


    /**
     * Constructs a new game frame
     *
     * @param buttonHandler ActionHandler event handler assigned to buttons
     * @param radioHandler  ItemListener event handler assigned to radio buttons
     */
    public GameFrame(ActionListener buttonHandler, ItemListener radioHandler) {
        super(WINDOW_TITLE);
        setLayout(new BorderLayout(5, 5));

        // Create and format title
        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Courier", Font.PLAIN, 20));
        questionLabel.setBorder(new EmptyBorder(30, 10, 0, 10));
        add(questionLabel, BorderLayout.NORTH);

        // Create and format Buttons
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
        add(centerPanel, BorderLayout.CENTER);


        // Create and format radio buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        ButtonGroup radioGroup = new ButtonGroup();

        String[] difficultyNames = new String[]{Question.EASY, Question.MEDIUM, Question.HARD};
        for (int i = 0; i < difficultyButtons.length; i++) {
            difficultyButtons[i] = new JRadioButton(difficultyNames[i], i == 1);
            difficultyButtons[i].setName(difficultyNames[i]);
            difficultyButtons[i].addItemListener(radioHandler);
            bottomPanel.add(difficultyButtons[i]);
            radioGroup.add(difficultyButtons[i]);
        }
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Given a question updates the frame questions
     * @param question Question question's values to be displayed on screen
     */
    public void updateUI(Question question) {
        questionLabel.setText(String.format(QUESTION_FORMAT, question.getQuestionText()));
        String[] answers = question.getAnswers();
        for (int i = 0; i < answers.length; i++) {
            answerButtons[i].setText(answers[i]);
        }
    }
}

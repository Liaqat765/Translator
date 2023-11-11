package QuizAppli.QuizAppli;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class QuizUI {
    private JFrame frame;
    private Question[] questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private JLabel timerLabel;
    private JLabel questionLabel;
    private ButtonGroup optionGroup;
    private JButton nextButton;

    public QuizUI(Question[] questions) {
        this.questions = questions;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java Quiz App");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Initialize timer before setting the initial time on the label
        timer = new Timer(60000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTimer();
            }
        });
        timer.start();

        timerLabel = new JLabel("Time: 01:00");
        panel.add(timerLabel);

        questionLabel = new JLabel("");
        panel.add(questionLabel);

        optionGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            JRadioButton optionButton = new JRadioButton("");
            optionGroup.add(optionButton);
            panel.add(optionButton);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleNextButtonClick();
            }
        });
        panel.add(nextButton);

        currentQuestionIndex = 0;
        score = 0;

        displayQuestion();

        frame.setVisible(true);
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.length) {
            Question currentQuestion = questions[currentQuestionIndex];
            questionLabel.setText(currentQuestion.getQuestionText());

            String[] options = currentQuestion.getOptions();
            Enumeration<AbstractButton> buttons = optionGroup.getElements();

            for (int i = 0; i < options.length && buttons.hasMoreElements(); i++) {
                JRadioButton optionButton = (JRadioButton) buttons.nextElement();
                optionButton.setText(options[i]);
            }
        } else {
            endQuiz();
        }
    }

    private void handleNextButtonClick() {
        Question currentQuestion = questions[currentQuestionIndex];
        int selectedOptionIndex = getSelectedOptionIndex();

        if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
            score++;
        }

        currentQuestionIndex++;
        clearSelection();

        displayQuestion();
    }

    private void updateTimer() {
        int remainingSeconds = timer.getDelay() / 1000;
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

        String formattedTime = String.format("%02d:%02d", minutes, seconds);
        timerLabel.setText(formattedTime);

        if (remainingSeconds == 0) {
            endQuiz();
        } else {
            timer.setDelay(timer.getDelay() - 1000);
        }
    }



    private int getSelectedOptionIndex() {
        Enumeration<AbstractButton> buttons = optionGroup.getElements();
        for (int i = 0; buttons.hasMoreElements(); i++) {
            JRadioButton optionButton = (JRadioButton) buttons.nextElement();
            if (optionButton.isSelected()) {
                return i;
            }
        }
        return -1;
    }


    private void clearSelection() {
        optionGroup.clearSelection();
    }

    public void setTimerDelay(int milliseconds) {
        timer.setDelay(milliseconds);
    }

    private void endQuiz() {
        timer.stop();
        nextButton.setEnabled(false);
        JOptionPane.showMessageDialog(frame, "Quiz Over!\nYour Score: " + score);
        // Add logic to save initials and score here
        frame.dispose();
    }
}

package view;

import data_access.DatabaseRetriever;
import entity.Answer;
import entity.Question;
import interface_adapter.logout.LogoutController;
import interface_adapter.testmodequestion.TestModeQuestionController;
import interface_adapter.testmodequestion.TestModeQuestionState;
import interface_adapter.testmodequestion.TestModeQuestionViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The View of Test Mode Question.
 */
public class TestModeQuestionView extends JPanel implements ActionListener {
    private final String viewName = "test mode question";

    private LogoutController logoutController;
    private final TestModeQuestionViewModel testModeQuestionViewModel;
    private TestModeQuestionController testModeQuestionController;

    private final JLabel username;
    private final JLabel testmodequestion;
    private final JButton option1;
    private final JButton option2;
    private final JButton option3;
    private final JButton option4;
    private final JButton nextButton;

    private LinkedList<Question> questions;
    private Question currentQuestion;
    private ArrayList<String> wrongquestions = new ArrayList<>();
    private int correctquestions;

    public TestModeQuestionView(TestModeQuestionViewModel testModeQuestionViewModel) throws SQLException {
        this.testModeQuestionViewModel = testModeQuestionViewModel;
        this.setBackground(Color.decode("#9BA8AB"));

        //TODO:uncomment 回来
//        this.questions = DatabaseRetriever.getQuestionsRandom();
        this.questions = DatabaseRetriever.getQuestionsInRange(0,3);
        this.wrongquestions = new ArrayList<>();

        final JLabel title = new JLabel("Test Mode Question");
        final int fontsize = 25;
        title.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
        title.setForeground(Color.decode("#4A5C6A"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        testmodequestion = new JLabel("Question needed to be added");
        testmodequestion.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        //        buttons.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        option1 = new JButton("Option 1");
        buttons.add(option1);
        buttons.add(Box.createVerticalStrut(10));

        option2 = new JButton("Option 2");
        buttons.add(option2);
        buttons.add(Box.createVerticalStrut(10));

        option3 = new JButton("Option 3");
        buttons.add(option3);
        buttons.add(Box.createVerticalStrut(10));

        option4 = new JButton("Option 4");
        buttons.add(option4);
        buttons.add(Box.createVerticalStrut(10));

        nextButton = new JButton("Next");
        // disable nextButton at first
        nextButton.setEnabled(false);
        nextButton.setBounds(300, 400, 80, 30);
        buttons.add(nextButton);
        buttons.setBackground(Color.decode("#9BA8AB"));

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        loadNextQuestion();

        // Take user to 'begin view' page based on their selection
        option1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (currentQuestion.getAnswers().get(0).isCorrect()) {
                            option1.setBackground(Color.GREEN);
                            option1.revalidate();
                            option1.setOpaque(true);
                            option1.repaint();
                            correctquestions++;

                        }
                        else {
                            option1.setBackground(Color.RED);
                            option1.revalidate();
                            option1.setOpaque(true);
                            option1.repaint();
                            if (!(wrongquestions.contains(currentQuestion))) {
                                wrongquestions.add(currentQuestion.getQuestionText());
                            }
                        }
                        // Enable "Next" button after an option is selected
                        nextButton.setEnabled(true);
                    }
                }
        );

        option2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (currentQuestion.getAnswers().get(1).isCorrect()) {
                            option2.setBackground(Color.GREEN);
                            option2.revalidate();
                            option2.setOpaque(true);
                            option2.repaint();
                            correctquestions++;

                        }
                        else {
                            option2.setBackground(Color.RED);
                            option2.revalidate();
                            option2.setOpaque(true);
                            option2.repaint();
                            if (!(wrongquestions.contains(currentQuestion))) {
                                wrongquestions.add(currentQuestion.getQuestionText());
                            }
                        }
                        // Enable "Next" button after an option is selected
                        nextButton.setEnabled(true);
                    }
                }
        );

        option3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (currentQuestion.getAnswers().get(2).isCorrect()) {
                            option3.setBackground(Color.GREEN);
                            option3.revalidate();
                            option3.setOpaque(true);
                            option3.repaint();
                            correctquestions++;

                        }
                        else {
                            option3.setBackground(Color.RED);
                            option3.revalidate();
                            option3.setOpaque(true);
                            option3.repaint();
                            if (!(wrongquestions.contains(currentQuestion))) {
                                wrongquestions.add(currentQuestion.getQuestionText());
                            }
                        }
                        // Enable "Next" button after an option is selected
                        nextButton.setEnabled(true);
                    }
                }
        );

        option4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (currentQuestion.getAnswers().get(3).isCorrect()) {
                            option4.setBackground(Color.GREEN);
                            option4.revalidate();
                            option4.setOpaque(true);
                            option4.repaint();
                            correctquestions++;

                        }
                        else {
                            option4.setBackground(Color.RED);
                            option4.revalidate();
                            option4.setOpaque(true);
                            option4.repaint();
                            if (!(wrongquestions.contains(currentQuestion))) {
                                wrongquestions.add(currentQuestion.getQuestionText());
                            }

                        }
                        // Enable "Next" button after an option is selected
                        nextButton.setEnabled(true);
                    }
                }
        );

        nextButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // Disable again until a new option is selected
                        nextButton.setEnabled(false);
                        loadNextQuestion();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(testmodequestion);
        this.add(buttons);

        this.add(usernameInfo);
        this.add(username);
    }

    private void loadNextQuestion() {
        if (!questions.isEmpty()) {
            currentQuestion = questions.poll();
            testmodequestion.setText("<html><p style='width:350px;'>" + currentQuestion.getQuestionText()
                    + "</p></html>");

            final List<Answer> answers = currentQuestion.getAnswers();
            final JButton[] options = {option1, option2, option3, option4};

            for (int i = 0; i < 4; i++) {
                if (i < answers.size()) {
                    options[i].setText("<html><p style='width:300px;'>" + answers.get(i).getAnswerText() 
                                       + "</p></html>");
                    options[i].setEnabled(true);
                    // Reset button color
                    options[i].setBackground(null);
                }
                else {
                    options[i].setText("N/A");
                    options[i].setEnabled(false);
                }
            }
        }
        else {
            // End session if no more questions
            // link to test result
            //            JOptionPane.showMessageDialog(
            //                    this,
            //                    "You have completed the study mode!",
            //                    "Done",
            //                    JOptionPane.INFORMATION_MESSAGE
            //            );

            final TestModeQuestionState testModeQuestionState = testModeQuestionViewModel.getState();
            testModeQuestionState.setCorrectQuestions(correctquestions);
            testModeQuestionState.setIncorrectQuestions(wrongquestions);
            System.out.println(wrongquestions);
            testModeQuestionViewModel.setState(testModeQuestionState);
            testModeQuestionViewModel.firePropertyChanged();
            testModeQuestionController.execute(testModeQuestionState.getCorrectQuestions(), testModeQuestionState.getIncorrectQuestions());
            testModeQuestionController.switchToTestResultView();

        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

    public void setTestModeQuestionController(TestModeQuestionController testModeQuestionController) {
        this.testModeQuestionController = testModeQuestionController;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

}

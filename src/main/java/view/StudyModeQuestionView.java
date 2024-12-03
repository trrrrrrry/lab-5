package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data_access.DatabaseRetriever;
import entity.Answer;
import entity.Question;
import interface_adapter.logout.LogoutController;
import interface_adapter.studymodequestion.StudyModeQuestionController;
import interface_adapter.studymodequestion.StudyModeQuestionViewModel;

/**
 * The View of Study Mode Question.
 */
public class StudyModeQuestionView extends JPanel implements ActionListener {
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int TEN = 10;
    private static final int THRITY = 30;
    private static final int EIGHTY = 80;
    private static final int THREEHUNDRED = 300;
    private static final int FOURHUNDRED = 400;
    private static final int ONETWOTHREE = 123;
    private static final int ONEHUNDRED = 100;

    private final String viewName = "study mode question";

    private LogoutController logoutController;
    private final StudyModeQuestionViewModel studyModeQuestionViewModel;
    private StudyModeQuestionController studyModeQuestionController;

    private final JLabel username;
    private final JLabel studymodequestion;
    private final JButton option1;
    private final JButton option2;
    private final JButton option3;
    private final JButton option4;
    private final JButton nextButton;
    private final JButton finishButton;

    private LinkedList<Question> questions = new LinkedList<>();
    private Question currentQuestion;
    private String moduleName;
    private final int randomNum;

    public StudyModeQuestionView(StudyModeQuestionViewModel studyModeQuestionViewModel) throws SQLException {
        this.studyModeQuestionViewModel = studyModeQuestionViewModel;
        final Random random = new Random();
        this.setBackground(Color.decode("#FBFADA"));
        this.randomNum = random.nextInt(6) + 1;
        getModuleQuestion();
        //        this.questions = DatabaseRetriever.getQuestionsFromStart(0);
        //        this.moduleName = studyModeQuestionViewModel.getState().getModule();
        //        this.questions = new LinkedList<>();
        //        XXXXX
        //        studyModeQuestionViewModel.addPropertyChangeListener(evt -> {
        //            if ("state".equals(evt.getPropertyName())) {
        //                this.moduleName = studyModeQuestionViewModel.getState().getModule();
        //
        //                System.out.println(this.moduleName);
        //                //                getModuleQuestion();
        //                try {
        //                    getModuleQuestion();
        //                }
        //                catch (SQLException ex) {
        //                    throw new RuntimeException(ex);
        //                }
        //            }
        //        });
        //        XXXXX
        //        final JLabel title = new JLabel("Study Mode Question");
        //        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //        studymodequestion = new JLabel(("Question needed to be added"));

        final JLabel title = new JLabel("Study Mode Question");
        final int fontsize = 25;
        title.setFont(new Font("Times New Roman", Font.ITALIC, fontsize));
        title.setForeground(Color.decode("#436580"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        studymodequestion = new JLabel("Question needed to be added ");
        studymodequestion.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        //        buttons.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        option1 = new JButton("Option 1");
        buttons.add(option1);
        buttons.add(Box.createVerticalStrut(TEN));

        option2 = new JButton("Option 2");
        buttons.add(option2);
        buttons.add(Box.createVerticalStrut(TEN));

        option3 = new JButton("Option 3");
        buttons.add(option3);
        buttons.add(Box.createVerticalStrut(TEN));

        option4 = new JButton("Option 4");
        buttons.add(option4);

        nextButton = new JButton("Next");
        // disable nextButton at first
        nextButton.setEnabled(false);

        nextButton.setBounds(THREEHUNDRED, FOURHUNDRED, EIGHTY, THRITY);
        buttons.setBackground(Color.decode("#FBFADA"));

        buttons.add(nextButton);

        finishButton = new JButton("finish");
        // disable nextButton at first
        finishButton.setEnabled(false);
        finishButton.setBounds(THREEHUNDRED, FOURHUNDRED, EIGHTY, THRITY);
        buttons.add(finishButton);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        loadNextQuestion();

        // Take user to 'begin view' page based on their selection
        option1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        optionsaction(0, option1);
                    }
                }
        );

        option2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        optionsaction(1, option3);
                    }
                }
        );

        option3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        optionsaction(2, option3);
                    }
                }
        );

        option4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        optionsaction(3, option4);
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
        this.add(studymodequestion);
        this.add(buttons);

        this.add(usernameInfo);
        this.add(username);
    }

    //    private void getModuleQuestion() throws SQLException {
    //        if ("Module 1".equals(moduleName)) {
    //            return DatabaseRetriever.getQuestionsFromStart(0);
    //            this.questions = DatabaseRetriever.getQuestionsFromStart(0);
    //
    //        }
    //        else if ("Module 2".equals(moduleName)) {
    //            return DatabaseRetriever.getQuestionsFromStart(20);
    //            this.questions = DatabaseRetriever.getQuestionsFromStart(20);
    //
    //        }
    //        else if ("Module 3".equals(moduleName)) {
    //            return DatabaseRetriever.getQuestionsFromStart(40);
    //            this.questions = DatabaseRetriever.getQuestionsFromStart(40);
    //
    //        }
    //        else if ("Module 4".equals(moduleName)) {
    //            return DatabaseRetriever.getQuestionsFromStart(60);
    //            this.questions = DatabaseRetriever.getQuestionsFromStart(60);
    //
    //        }
    //        else if ("Module 5".equals(moduleName)) {
    //             return DatabaseRetriever.getQuestionsFromStart(80);
    //            this.questions = DatabaseRetriever.getQuestionsFromStart(80);
    //        }
    //        else {
    // return DatabaseRetriever.getQuestionsInRange(100,123);
    //            this.questions = DatabaseRetriever.getQuestionsInRange(100,123);
    //
    //        }
    //
    //    }

    private void getModuleQuestion() throws SQLException {
        if (this.randomNum == 1) {
            //            return DatabaseRetriever.getQuestionsFromStart(0);
            this.questions = DatabaseRetriever.getQuestionsFromStart(0);

        }
        else if (this.randomNum == 2) {
            //            return DatabaseRetriever.getQuestionsFromStart(20);
            this.questions = DatabaseRetriever.getQuestionsFromStart(20);

        }
        else if (this.randomNum == 3) {
            //            return DatabaseRetriever.getQuestionsFromStart(40);
            this.questions = DatabaseRetriever.getQuestionsFromStart(40);

        }
        else if (this.randomNum == 4) {
            //            return DatabaseRetriever.getQuestionsFromStart(60);
            this.questions = DatabaseRetriever.getQuestionsFromStart(60);

        }
        else if (this.randomNum == 5) {
            //            return DatabaseRetriever.getQuestionsFromStart(80);
            this.questions = DatabaseRetriever.getQuestionsFromStart(EIGHTY);
        }
        else {
            //            return DatabaseRetriever.getQuestionsInRange(100,123);
            this.questions = DatabaseRetriever.getQuestionsInRange(ONEHUNDRED, ONETWOTHREE);

        }

    }

    private void optionsaction(int id, JButton options) {
        if (this.currentQuestion.getAnswers().get(id).isCorrect()) {
            options.setBackground(Color.GREEN);
            options.revalidate();
            options.setOpaque(true);
            options.repaint();

        }
        else {
            options.setBackground(Color.RED);
            options.revalidate();
            options.setOpaque(true);
            options.repaint();
            if (!this.questions.contains(this.currentQuestion)) {
                this.questions.add(this.currentQuestion);
            }
        }
        // Enable "Next" button after an option is selected
        this.nextButton.setEnabled(true);
    }

    /**
     * LoadNextQuestion load the next question.
     */
    public void loadNextQuestion() {
        //        if (this.questions == null || this.questions.isEmpty()) {
        //            System.out.print("no questions available yet.");
        //        }

        if (!this.questions.isEmpty()) {
            currentQuestion = this.questions.poll();
            studymodequestion.setText("<html><p style='width:350px;'>" + currentQuestion.getQuestionText()
                    + "</p></html>");

            final List<Answer> answers = currentQuestion.getAnswers();
            final JButton[] options = {option1, option2, option3, option4};

            for (int i = 0; i < FOUR; i++) {
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
            //            JOptionPane.showMessageDialog(
            //                    this,
            //                    "You have completed the study mode!",
            //                    "Done",
            //                    JOptionPane.INFORMATION_MESSAGE
            //            );
            studyModeQuestionController.switchToStudyModeView();

        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

    public void setStudyModeQuestionController(StudyModeQuestionController controller) {
        this.studyModeQuestionController = controller;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    public JLabel getCurrentQuestion() {
        return studymodequestion;
    }

    public JButton[] getOptionsButtons() {
        final JButton[] buttons = {option1, option2, option3, option4};
        return buttons;
    }
}

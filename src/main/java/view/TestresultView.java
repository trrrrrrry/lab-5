
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

import interface_adapter.testresult.TestresultController;
import interface_adapter.testresult.TestresultViewModel;

/**
 * The view for test result use case.
 */
public class TestresultView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "test result";

    private final TestresultViewModel testresultViewModel;

    private TestresultController testresultController;

    private final JButton finish = new JButton("Finish");

    private final Color backgroundC = Color.decode("#c1e8ff");
    private final Color backgroundB = Color.decode("#7da0ca");

    private int correctQuestions;

    private ArrayList<String> wrongqueestions;

    public TestresultView(TestresultViewModel viewModel) {
        this.testresultViewModel = viewModel;
        testresultViewModel.addPropertyChangeListener(this);

        //        final int correctQuestions = testresultViewModel.getState().getCorrectQuestions();
        this.correctQuestions = 0;
        final ArrayList<String> incorrectQuestions = testresultViewModel.getState().getIncorrectQuestions();

        final JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(backgroundB);
        final int tbMargin = 20;
        titlePanel.setBorder(BorderFactory.createEmptyBorder(tbMargin, 0, tbMargin, 0));

        final JLabel title = new JLabel(TestresultViewModel.TITLE_LABEL, SwingConstants.CENTER);
        final int fontTitle = 32;
        title.setFont(new Font("Times New Roman", Font.BOLD, fontTitle));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(title, BorderLayout.CENTER);

        final JLabel correctQuestionsLabel = new JLabel("You got "
                + correctQuestions + " correct questions for this test.");

        final JPanel incorrectQuestionsPanel = new JPanel();
        incorrectQuestionsPanel.setLayout(new BoxLayout(incorrectQuestionsPanel, BoxLayout.Y_AXIS));
        incorrectQuestionsPanel.setBackground(backgroundC);
        final int scMargin = 15;
        incorrectQuestionsPanel.setBorder(BorderFactory.createEmptyBorder(scMargin, 0, scMargin, 0));
        final JLabel[] incorrectQuestionsLabel = new JLabel[1];

        testresultViewModel.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName())) {
                this.correctQuestions = testresultViewModel.getState().getCorrectQuestions();
                this.wrongqueestions = testresultViewModel.getState().getIncorrectQuestions();
                System.out.println(this.correctQuestions);
                System.out.println(this.wrongqueestions);
                correctQuestionsLabel.setText("You got "
                        + this.correctQuestions + " correct questions for this test.");
                final int fontSubtitle = 24;
                correctQuestionsLabel.setFont(new Font("Times New Roman", Font.PLAIN, fontSubtitle));
                correctQuestionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                if (this.wrongqueestions.isEmpty()) {
                    incorrectQuestionsLabel[0] = new JLabel("Congratulations! You answered all 40 "
                            + "questions correctly for this test.");
                    incorrectQuestionsLabel[0].setFont(new Font("Times New Roman", Font.PLAIN, fontSubtitle));
                    incorrectQuestionsLabel[0].setAlignmentX(Component.CENTER_ALIGNMENT);
                    incorrectQuestionsPanel.add(incorrectQuestionsLabel[0]);

                }
                else {
                    incorrectQuestionsLabel[0] = new JLabel("Incorrect questions you got from this test is(are): ");
                    incorrectQuestionsLabel[0].setAlignmentX(Component.CENTER_ALIGNMENT);
                    incorrectQuestionsLabel[0].setFont(new Font("Times New Roman", Font.PLAIN, fontSubtitle));
                    incorrectQuestionsPanel.add(incorrectQuestionsLabel[0]);
                    for (String question: wrongqueestions) {
                        final JTextArea questionArea = new JTextArea("-" + question);
                        questionArea.setLineWrap(true);
                        questionArea.setWrapStyleWord(true);
                        questionArea.setEditable(false);
                        questionArea.setBackground(backgroundC);
                        incorrectQuestionsPanel.add(questionArea);
                    }
                }
            }
        });

        //        final JPanel incorrectQuestionsPanel = new JPanel();
        //        incorrectQuestionsPanel.setLayout(new BoxLayout(incorrectQuestionsPanel, BoxLayout.Y_AXIS));
        //        incorrectQuestionsPanel.setBackground(backgroundC);
        //        final JLabel incorrectQuestionsLabel;
        //        if (viewModel.getIncorrectQuestions().isEmpty()) {
        //            incorrectQuestionsLabel[0] = new JLabel("Congratulations! You answered all 40 "
        //                    + "questions correctly for this test.");
        //        }
        //        else {
        //            incorrectQuestionsLabel[0] = new JLabel("Incorrect questions you got from this test is(are): ");
        //        }

        //        for (String question: wrongqueestions) {
        //            incorrectQuestionsPanel.add(new JLabel("- " + question));
        //        }
        //        incorrectQuestionsPanel.add(incorrectQuestionsLabel[0]);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(backgroundC);
        this.add(titlePanel);
        this.add(correctQuestionsLabel);
        incorrectQuestionsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(incorrectQuestionsPanel);
        finish.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(finish);
        finish.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        testresultController.switchToLoggedInView();
                    }
                }
        );

    }

    public String getViewName() {
        return viewName;
    }

    public void setTestResultController(TestresultController controller) {
        this.testresultController = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // no implementation needed for this view.
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // no implementation needed for this view.
    }
}
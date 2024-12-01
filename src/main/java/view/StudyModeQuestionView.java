package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.logout.LogoutController;
import interface_adapter.studymodequestion.StudyModeQuestionController;
import interface_adapter.studymodequestion.StudyModeQuestionViewModel;

/**
 * The View of Study Mode Question.
 */
public class StudyModeQuestionView extends JPanel implements ActionListener {
    private final String viewName = "study mode question";

    private LogoutController logoutController;
    private final StudyModeQuestionViewModel studyModeQuestionViewModel;
    private StudyModeQuestionController studyModeQuestionController;

    private final JLabel username;
    // TODO: label for question?
    private final JButton option1;
    private final JButton option2;
    private final JButton option3;
    private final JButton option4;

    public StudyModeQuestionView(StudyModeQuestionViewModel studyModeQuestionViewModel) {
        this.studyModeQuestionViewModel = studyModeQuestionViewModel;

        final JLabel title = new JLabel("Study Mode Question");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: Add question
        final JLabel studymodequestion = new JLabel("Question needed to be added ");
        studymodequestion.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(2, 3, 10, 10));

        // TODO: Option needed to be added
        option1 = new JButton("Option 1");
        buttons.add(option1);
        option2 = new JButton("Option 2");
        buttons.add(option2);
        option3 = new JButton("Option 3");
        buttons.add(option3);
        option4 = new JButton("Option 4");
        buttons.add(option4);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Take user to 'begin view' page based on their selection
//        option1.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(option1)) {
//                            final StudyModeState studyModeState = studyModeQuestionViewModel.getState();
//                            studyModeState.setModule("Module 1");
//                            studyModeQuestionController.execute(studyModeState.getModule());
//                        }
//                        studyModeQuestionController.switchToStudyModeBeginView();
//                    }
//                }
//        );
//
//        option2.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(option2)) {
//                            final StudyModeState studyModeState = studyModeQuestionViewModel.getState();
//
//                            studyModeQuestionController.execute(studyModeState.getModule());
//                        }
//                        studyModeQuestionController.switchToStudyModeBeginView();
//                    }
//                }
//        );
//
//        option3.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(option3)) {
//                            final StudyModeState studyModeState = studyModeQuestionViewModel.getState();
//
//                            studyModeQuestionController.execute(studyModeState.getModule());
//                        }
//                        studyModeQuestionController.switchToStudyModeBeginView();
//                    }
//                }
//        );
//
//        option4.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(option4)) {
//                            final StudyModeState studyModeState = studyModeQuestionViewModel.getState();
//
//                            studyModeQuestionController.execute(studyModeState.getModule());
//                        }
//                        studyModeQuestionController.switchToStudyModeBeginView();
//                    }
//                }
//        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(studymodequestion);
        this.add(buttons);

        this.add(usernameInfo);
        this.add(username);
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

}

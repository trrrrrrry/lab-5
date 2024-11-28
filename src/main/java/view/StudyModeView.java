package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.logout.LogoutController;
import interface_adapter.studymode.StudyModeController;
import interface_adapter.studymode.StudyModeState;
import interface_adapter.studymode.StudyModeViewModel;

/**
 * The View when the user select Study Mode.
 */
public class StudyModeView extends JPanel implements ActionListener {
    private final String viewName = "study mode";

    private LogoutController logoutController;
    private final StudyModeViewModel studymodeViewModel;
    private StudyModeController studyModeController;

    private final JLabel username;
    private final JButton module1;
    private final JButton module2;
    private final JButton module3;
    private final JButton module4;
    private final JButton module5;
    private final JButton module6;
    private final JButton backToModeSelection;

    public StudyModeView(StudyModeViewModel studyModeViewModel) {
        this.studymodeViewModel = studyModeViewModel;

        final JLabel title = new JLabel("Study Mode");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel moduleSelection = new JLabel("Please select a module from the below: ");
        moduleSelection.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(2, 3, 10, 10));

        module1 = new JButton("Module 1");
        buttons.add(module1);
        module2 = new JButton("Module 2");
        buttons.add(module2);
        module3 = new JButton("Module 3");
        buttons.add(module3);
        module4 = new JButton("Module 4");
        buttons.add(module4);
        module5 = new JButton("Module 5");
        buttons.add(module5);
        module6 = new JButton("Module 6");
        buttons.add(module6);
        backToModeSelection = new JButton("Back To Mode Selection");

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Take user to 'begin view' page based on their selection
        module1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(module1)) {
                            final StudyModeState studyModeState = studyModeViewModel.getState();
                            studyModeState.setModule("Module 1");
                            studyModeController.execute(studyModeState.getModule());
                        }
                        studyModeController.switchToStudyModeBeginView();
                    }
                }
        );

        module2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(module2)) {
                            final StudyModeState studyModeState = studyModeViewModel.getState();
                            studyModeState.setModule("Module 2");
                            studyModeController.execute(studyModeState.getModule());
                        }
                        studyModeController.switchToStudyModeBeginView();
                    }
                }
        );

        module3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(module3)) {
                            final StudyModeState studyModeState = studyModeViewModel.getState();
                            studyModeState.setModule("Module 3");
                            studyModeController.execute(studyModeState.getModule());
                        }
                        studyModeController.switchToStudyModeBeginView();
                    }
                }
        );

        module4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(module4)) {
                            final StudyModeState studyModeState = studyModeViewModel.getState();
                            studyModeState.setModule("Module 4");
                            studyModeController.execute(studyModeState.getModule());
                        }
                        studyModeController.switchToStudyModeBeginView();
                    }
                }
        );

        module5.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(module5)) {
                            final StudyModeState studyModeState = studyModeViewModel.getState();
                            studyModeState.setModule("Module 5");
                            studyModeController.execute(studyModeState.getModule());
                        }
                        studyModeController.switchToStudyModeBeginView();
                    }
                }
        );

        module6.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(module6)) {
                            final StudyModeState studyModeState = studyModeViewModel.getState();
                            studyModeState.setModule("Module 6");
                            studyModeController.execute(studyModeState.getModule());
                        }
                        studyModeController.switchToStudyModeBeginView();
                    }
                }
        );

        backToModeSelection.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        studyModeController.switchToModeSelectionView();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(moduleSelection);
        this.add(buttons);

        this.add(backToModeSelection);

        this.add(usernameInfo);
        this.add(username);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

    public void setStudyModeController(StudyModeController controller) {
        this.studyModeController = controller;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}

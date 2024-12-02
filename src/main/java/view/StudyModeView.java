package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

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
    private final JPanel buttonWrapper;

    public StudyModeView(StudyModeViewModel studyModeViewModel) {
        this.studymodeViewModel = studyModeViewModel;
        this.setBackground(Color.decode("#11212D"));

        final int titleFontSize = 25;
        final JLabel title = new JLabel("Study Mode\n");
        title.setFont(new Font("Times New Roman", Font.ITALIC, titleFontSize));
        title.setForeground(Color.decode("#4A5C6A"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel moduleSelection = new JLabel("<html><div style='text-align: center; font-family: "
                + "\"Times New Roman\"; margin: 10px auto; color: #7DA0CA; font-size: 25'>"
                + "Please select a module from the below: ");
        moduleSelection.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        buttons.setBackground(Color.decode("#11212D"));
        final int buttonsRows = 2;
        final int buttonsCols = 3;
        final int buttonsHgap = 10;
        final int buttonsVgap = 10;
        buttons.setLayout(new GridLayout(buttonsRows, buttonsCols, buttonsHgap, buttonsVgap));

        final String foreColor = "#9BA8AB";
        final String backColor = "#253745";
        module1 = new JButton("Module 1");
        module1.setForeground(Color.decode(foreColor));
        module1.setBackground(Color.decode(backColor));
        buttons.add(module1);
        module2 = new JButton("Module 2");
        module2.setForeground(Color.decode(foreColor));
        module2.setBackground(Color.decode(backColor));
        buttons.add(module2);
        module3 = new JButton("Module 3");
        module3.setForeground(Color.decode(foreColor));
        module3.setBackground(Color.decode(backColor));
        buttons.add(module3);
        module4 = new JButton("Module 4");
        module4.setForeground(Color.decode(foreColor));
        module4.setBackground(Color.decode(backColor));
        buttons.add(module4);
        module5 = new JButton("Module 5");
        module5.setForeground(Color.decode(foreColor));
        module5.setBackground(Color.decode(backColor));
        buttons.add(module5);
        module6 = new JButton("Module 6");
        module6.setForeground(Color.decode(foreColor));
        module6.setBackground(Color.decode(backColor));
        buttons.add(module6);

        backToModeSelection = new JButton("Back To Mode Selection");
        backToModeSelection.setAlignmentX(Component.CENTER_ALIGNMENT);

        final int wrapperMargin = 20;
        buttonWrapper = new JPanel();
        buttonWrapper.setLayout(new BoxLayout(buttonWrapper, BoxLayout.Y_AXIS));
        buttonWrapper.setOpaque(false);
        buttonWrapper.setBorder(BorderFactory.createEmptyBorder(wrapperMargin, 0, wrapperMargin, 0));
        buttonWrapper.add(backToModeSelection);

        backToModeSelection.setBackground(Color.decode("#9BA8AB"));
        backToModeSelection.setForeground(Color.decode("#253745"));
        backToModeSelection.setFocusPainted(false);
        backToModeSelection.setOpaque(true);
        backToModeSelection.setBorderPainted(false);

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
                            studyModeViewModel.setState(studyModeState);
                            studyModeViewModel.firePropertyChanged();
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
                            studyModeViewModel.setState(studyModeState);
                            studyModeViewModel.firePropertyChanged();
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
                            studyModeViewModel.setState(studyModeState);
                            studyModeViewModel.firePropertyChanged();
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
                            studyModeViewModel.setState(studyModeState);
                            studyModeViewModel.firePropertyChanged();
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
                            studyModeViewModel.setState(studyModeState);
                            studyModeViewModel.firePropertyChanged();
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
                            studyModeViewModel.setState(studyModeState);
                            studyModeViewModel.firePropertyChanged();
                            studyModeController.execute(studyModeState.getModule());
                        }
                        studyModeController.switchToStudyModeBeginView();
                    }
                }
        );

        // Take user back to <LoggedInView>
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

        this.add(buttonWrapper);

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

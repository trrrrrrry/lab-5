package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.logout.LogoutController;
import interface_adapter.studymodebegin.StudyModeBeginController;
import interface_adapter.studymodebegin.StudyModeBeginViewModel;

/**
 * The View after user selected a topic to study on - the 'Begin' Page.
 */
public class StudyModeBeginView extends JPanel {
    private final String viewName = "study mode begin";

    private LogoutController logoutController;
    private final StudyModeBeginViewModel studyModeBeginViewModel;
    private StudyModeBeginController studyModeBeginController;

    private final JButton begin;
    private final JLabel username;

    public StudyModeBeginView(StudyModeBeginViewModel studyModeBeginViewModel) {

        this.studyModeBeginViewModel = studyModeBeginViewModel;

        final String moduleName = studyModeBeginViewModel.getState().getModule();

        final JLabel title = new JLabel("Study Mode");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel beginText = new JLabel("<html>Welcome to study "
                + moduleName + ". The questions you get wrong will be "
                + " redisplayed until you answer all of them correctly.</html>");
        beginText.setAlignmentX(Component.CENTER_ALIGNMENT);
        beginText.setFont(new Font("Arial", Font.PLAIN, 20));

        final JPanel buttons = new JPanel();
        begin = new JButton("Begin");
        buttons.add(begin);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Take user to 'question view' page based on their selection
        // begin.addActionListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(beginText);
        this.add(buttons);

        this.add(usernameInfo);
        this.add(username);
    }

    public String getViewName() {
        return viewName;
    }

    public void setStudyModeBeginController(StudyModeBeginController studyModeBeginController) {
        this.studyModeBeginController = studyModeBeginController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

}

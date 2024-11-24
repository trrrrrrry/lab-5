package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

        final JLabel beginText = new JLabel("Welcome to study " + ". The questions you get wrong will be "
                + " redisplayed until you answer all of them correctly.");
        beginText.setAlignmentX(Component.CENTER_ALIGNMENT);

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

package view;

import interface_adapter.logout.LogoutController;
import interface_adapter.testmode.TestModeController;
import interface_adapter.testmode.TestModeState;
import interface_adapter.testmode.TestModeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The View after user selected test mode.
 */
public class TestModeView extends JPanel {
    private final String viewName = "test mode";

    private LogoutController logoutController;
    private final TestModeViewModel testModeViewModel;
    private TestModeController testModeController;

    private final JButton begin;
    private final JButton backToModeSelection;
    private final JLabel username;
    private final JPanel buttonWrapper;

    public TestModeView(TestModeViewModel testModeViewModel) {

        this.testModeViewModel = testModeViewModel;
        this.setBackground(Color.decode("#11212D"));

        final JLabel title = new JLabel("Test Mode\n");
        title.setFont(new Font("Times New Roman", Font.ITALIC, 25));
        title.setForeground(Color.decode("#4A5C6A"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel beginText = new JLabel("<html>You have 40 Questions to answer. "
                + "To past the test, you need to get 36 questions correct. "
                + "For your reference, the time you used will be displayed, but the test is NOT timed.</html>");
        beginText.setAlignmentX(Component.CENTER_ALIGNMENT);
        beginText.setFont(new Font("Arial", Font.PLAIN, 20));

        testModeViewModel.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName())) {
                beginText.setText("<html><div style='text-align: center; font-family: \"Times New Roman\"; margin: 10px auto;'>"
                        + "<p style='color: #C1E8FF;'>You have 40 Questions to answer. "
                        + "To past the test, you need to get 36 questions correct. "
                        + "For your reference, the time you used will be displayed, but the test is NOT timed.</p></div></html>");
            }
        });

        final JPanel buttons = new JPanel();
        buttons.setBackground(Color.decode("#11212D"));
        final String fancyFont = "Lucida Handwriting";
        final int fontSize = 20;

        begin = new JButton("Begin");
        begin.setFont(new Font(fancyFont, Font.ITALIC, fontSize));
        begin.setForeground(Color.decode("#9BA8AB"));
        begin.setBackground(Color.decode("#253745"));
        buttons.add(begin);

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

        // Take user to 'question view' page
        begin.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(begin)) {
                            final TestModeState testModeState = testModeViewModel.getState();
                            testModeViewModel.setState(testModeState);
                            testModeViewModel.firePropertyChanged();
                            testModeController.execute();
                        }
                        testModeController.switchToTestModeQuestionView();
                    }
                }
        );

        backToModeSelection.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        testModeController.switchToModeSelectionView();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(beginText);
        this.add(buttons);
        this.add(backToModeSelection);

        this.add(buttonWrapper);

        this.add(usernameInfo);
        this.add(username);
    }

    public String getViewName() {
        return viewName;
    }

    public void setTestModeController(TestModeController testModeController) {
        this.testModeController = testModeController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

}

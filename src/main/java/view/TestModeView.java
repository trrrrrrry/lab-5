package view;

import interface_adapter.logout.LogoutController;
import interface_adapter.testmode.TestModeController;
import interface_adapter.testmode.TestModeViewModel;

import javax.swing.*;
import java.awt.*;

/**
 * The View after user selected test mode.
 */
public class TestModeView extends JPanel {
    private final String viewName = "test mode";

    private LogoutController logoutController;
    private final TestModeViewModel viewModel;
    private TestModeController testModeController;

    private final JButton begin;
    private final JLabel username;

    public TestModeView(TestModeViewModel viewModel) {
        this.viewModel = viewModel;

        final JLabel beginText = new JLabel("<html><p>You have 40 Questions to answer. "
                + "To past the test, you need to get 36 questions correct. "
                + "For your reference, the time you used will be displayed, but the test is NOT timed.");
        beginText.setAlignmentX(Component.CENTER_ALIGNMENT);
        beginText.setFont(new Font("Arial", Font.PLAIN, 20));

        final JPanel buttons = new JPanel();
        begin = new JButton("Begin");
        buttons.add(begin);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(beginText);
        this.add(buttons);

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

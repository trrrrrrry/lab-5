package view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.modeselection.ModeSelectionViewModel;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "mode selectin";
    private final ModeSelectionViewModel modeSelectionViewModel;
    private final JLabel passwordErrorField = new JLabel();
    private ChangePasswordController changePasswordController;
    private LogoutController logoutController;
    private final JLabel username;

    private final JButton study;
    private final JButton test;

    public LoggedInView(ModeSelectionViewModel modeSelectionViewModel) {
        this.modeSelectionViewModel = modeSelectionViewModel;
        this.modeSelectionViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Mode Selection View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();

        final JLabel modeSelection = new JLabel("Choose a Mode: ");
        modeSelection.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        study = new JButton("Study Mode");
        buttons.add(study);

        test = new JButton("Test Mode");
        buttons.add(test);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(modeSelection);

        this.add(buttons);

        this.add(usernameInfo);
        this.add(username);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setChangePasswordController(ChangePasswordController changePasswordController) {
        this.changePasswordController = changePasswordController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}

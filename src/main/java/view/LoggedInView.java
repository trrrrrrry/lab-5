package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.modeselection.ModeSelectionController;
import interface_adapter.modeselection.ModeSelectionViewModel;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final JLabel passwordErrorField = new JLabel();
    private ChangePasswordController changePasswordController;
    private LogoutController logoutController;
    private ModeSelectionController modeSelectionController;
    private final JLabel username;

    private final JButton logOut;
    private final JTextField passwordInputField = new JTextField(15);
    private final JButton changePassword;
    private final JButton study;
    private final JButton test;
    private final JPanel buttonWrapper;

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final int titleFontSize = 25;
        final JLabel title = new JLabel("Mode Selection");
        title.setFont(new Font("Times New Roman", Font.ITALIC, titleFontSize));
        title.setForeground(Color.decode("#4A5C6A"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel changeForPassword = new JLabel("If you wish to change your password, please "
                + "enter the new Password below");
        changeForPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("New Password"), passwordInputField);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username = new JLabel();
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel modeSelection = new JLabel("<html><div style='text-align: center; font-family: "
                + "\"Times New Roman\"; margin: 10px auto; color: #7DA0CA; font-size: 25'>"
                + "Choose a Mode: ");
        modeSelection.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        buttons.setBackground(Color.decode("#11212D"));
        final int buttonsRows = 2;
        final int buttonsCols = 3;
        final int buttonsHgap = 10;
        final int buttonsVgap = 10;
        buttons.setLayout(new GridLayout(buttonsRows, buttonsCols, buttonsHgap, buttonsVgap));

        final String foreColor = "#9BA8AB";
        final String backColor = "#253745";
        study = new JButton(ModeSelectionViewModel.STUDY_MODE_BUTTON_LABEL);
        study.setForeground(Color.decode(foreColor));
        study.setBackground(Color.decode(backColor));
        buttons.add(study);

        test = new JButton(ModeSelectionViewModel.TEST_MODE_BUTTON_LABEL);
        test.setForeground(Color.decode(foreColor));
        test.setBackground(Color.decode(backColor));
        buttons.add(test);

        logOut = new JButton("Log Out");
        logOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        changePassword = new JButton("Change Password");
        changePassword.setAlignmentX(Component.CENTER_ALIGNMENT);

        final int wrapperMargin = 20;
        buttonWrapper = new JPanel();
        buttonWrapper.setLayout(new BoxLayout(buttonWrapper, BoxLayout.Y_AXIS));
        buttonWrapper.setOpaque(false);
        buttonWrapper.setBorder(BorderFactory.createEmptyBorder(wrapperMargin, 0, wrapperMargin, 0));
        buttonWrapper.add(changePassword);
        buttonWrapper.add(logOut);

        changePassword.setBackground(Color.decode("#9BA8AB"));
        changePassword.setForeground(Color.decode("#253745"));
        changePassword.setFocusPainted(false);
        changePassword.setOpaque(true);
        changePassword.setBorderPainted(false);

        logOut.setBackground(Color.decode("#9BA8AB"));
        logOut.setForeground(Color.decode("#253745"));
        logOut.setFocusPainted(false);
        logOut.setOpaque(true);
        logOut.setBorderPainted(false);

        study.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        modeSelectionController.switchToStudyModeView();
                    }
                }
        );

        test.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        modeSelectionController.switchToTestModeView();
                    }
                }
        );

        changePassword.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(changePassword)) {
                        final LoggedInState currentState = loggedInViewModel.getState();
                        this.changePasswordController.execute(
                                currentState.getUsername(),
                                currentState.getPassword()
                        );
                    }
                }
        );

        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {
            private void documentListenerHelper() {
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setPassword(passwordInputField.getText());
                loggedInViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        final LoggedInState currentState = loggedInViewModel.getState();
                        // Execute the logout through the LogoutController
                        logoutController.execute(currentState.getUsername());
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(modeSelection);
        this.add(buttons);

        this.add(changeForPassword);
        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(changePassword);
        this.add(logOut);

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

    public void setModeSelectionController(ModeSelectionController modeSelectionController) {
        this.modeSelectionController = modeSelectionController;
    }
}

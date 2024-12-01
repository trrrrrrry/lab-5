package view;

import interface_adapter.logout.LogoutController;
import interface_adapter.testmodequestion.TestModeQuestionController;
import interface_adapter.testmodequestion.TestModeQuestionViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The View of Test Mode Question.
 */
public class TestModeQuestionView extends JPanel implements ActionListener {
    private final String viewName = "test mode question";

    private LogoutController logoutController;
    private final TestModeQuestionViewModel testModeQuestionViewModel;
    private TestModeQuestionController testModeQuestionController;

    private final JLabel username;
    // TODO: label for question?
    private final JButton option1;
    private final JButton option2;
    private final JButton option3;
    private final JButton option4;

    public TestModeQuestionView(TestModeQuestionViewModel testModeQuestionViewModel){
        this.testModeQuestionViewModel = testModeQuestionViewModel;

        final JLabel title = new JLabel("Test Mode Question");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: Add question
        final JLabel testmodequestion = new JLabel("Question needed to be added ");
        testmodequestion.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(testmodequestion);
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


    public void setTestModeQuestionController(TestModeQuestionController testModeQuestionController) {
        this.testModeQuestionController = testModeQuestionController;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }



}

package app;

import javax.swing.JFrame;
import java.sql.SQLException;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     * @throws SQLException throw exception
     */
    public static void main(String[] args) throws SQLException {
        final AppBuilder appBuilder = new AppBuilder();

        final JFrame application = appBuilder
                                            .addLoginView()
                                            .addSignupView()
                                            .addLoggedInView()
                                            .addStudyModeView()
                                            .addStudyModeBeginView()
                                            .addStudyModeQuestionView()
                                            .addTestModeView()
                                            .addTestModeQuestionView()
                                            .addTestResultView()
                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addLoggedInUseCase()
                                            .addStudyModeUseCase()
                                            .addStudyModeBeginUseCase()
                                            .addStudyModeQuestionUseCase()
                                            .addTestModeUseCase()
                                            .addTestModeQuestionUseCase()
                                            .addChangePasswordUseCase()
                                            .addLogoutUseCase()
                                            .addTestResultUseCase()
                                            .build();
        application.pack();
        final int sizeWidth = 500;
        final int sizeHeight = 360;
        application.setSize(sizeWidth, sizeHeight);
        application.setLocationRelativeTo(null);
        application.setVisible(true);

    }
}

package app;

import javax.swing.JFrame;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();

        final JFrame application = appBuilder
                                            .addLoginView()
                                            .addSignupView()
                                            .addLoggedInView()
                                            .addStudyModeView()
                                            .addTestResultView()
                                            .addStudyModeBeginView()
                                            .addStudyModeQuestionView()
                                            .addTestModeView()
                                            .addTestModeQuestionView()
                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addStudyModeUseCase()
                                            .addLoggedInUseCase()
                                            .addStudyModeBeginUseCase()
                                            .addStudyModeQuestionUseCase()
                                            .addTestResultView()
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

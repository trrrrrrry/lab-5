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
                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addStudyModeUseCase()
                                            .addLoggedInUseCase()
                                            .addStudyModeBeginUseCase()
                                            .addChangePasswordUseCase()
                                            .addLogoutUseCase()
                                            .addTestresultUseCase()
                                            .build();
        application.pack();
        application.setSize(500, 360);
        application.setLocationRelativeTo(null);
        application.setVisible(true);

    }
}

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
                                            .addTestModeView()
                                            .addSignupUseCase()
                                            .addLoginUseCase()
                                            .addStudyModeUseCase()
                                            .addLoggedInUseCase()
                                            .addStudyModeBeginUseCase()
                                            .addTestModeUseCase()
                                            .addChangePasswordUseCase()
                                            .addLogoutUseCase()
                                            .addTestresultUseCase()
                                            .build();
        application.pack();
        final int sizeWidth = 500;
        final int sizeHeight = 360;
        application.setSize(sizeWidth, sizeHeight);
        application.setLocationRelativeTo(null);
        application.setVisible(true);

    }
}

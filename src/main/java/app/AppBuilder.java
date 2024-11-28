package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.*;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.ChangePasswordPresenter;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.modeselection.ModeSelectionController;
import interface_adapter.modeselection.ModeSelectionPresenter;
import interface_adapter.modeselection.ModeSelectionViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.studymode.StudyModeController;
import interface_adapter.studymode.StudyModePresenter;
import interface_adapter.studymode.StudyModeViewModel;
import interface_adapter.studymodebegin.StudyModeBeginController;
import interface_adapter.studymodebegin.StudyModeBeginPresenter;
import interface_adapter.studymodebegin.StudyModeBeginViewModel;
import interface_adapter.studymodequestion.StudyModeQuestionViewModel;
import interface_adapter.testmode.TestModeController;
import interface_adapter.testmode.TestModePresenter;
import interface_adapter.testmode.TestModeViewModel;
import interface_adapter.testresult.TestresultController;
import interface_adapter.testresult.TestresultPresenter;
import interface_adapter.testresult.TestresultViewModel;
import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInteractor;
import use_case.change_password.ChangePasswordOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.modeselection.ModeSelectionInputBoundary;
import use_case.modeselection.ModeSelectionInteractor;
import use_case.modeselection.ModeSelectionOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.studymode.StudyModeInputBoundary;
import use_case.studymode.StudyModeInteractor;
import use_case.studymode.StudyModeOutputBoundary;
import use_case.studymodebegin.StudyModeBeginInputBoundary;
import use_case.studymodebegin.StudyModeBeginInteractor;
import use_case.studymodebegin.StudyModeBeginOutputBoundary;
import use_case.testmode.TestModeInputBoundary;
import use_case.testmode.TestModeInteractor;
import use_case.testmode.TestModeOutputBoundary;
import use_case.testresult.TestresultInputBoundary;
import use_case.testresult.TestresultInteractor;
import use_case.testresult.TestresultOutputBoundary;
import view.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term. ami
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final UserFactory userFactory = new CommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();
    private final InMemoryStudyModeDataAccessInterface studyModeDataAccessInterface = new InMemoryStudyModeDataAccessInterface();
    private final InMemoryStudyModeBeginDataAccessInterface studyModeBeginDataAccessInterface = new InMemoryStudyModeBeginDataAccessInterface();
    private final InMemoryTestModeDataAccessInterface testyModeDataAccessInterface = new InMemoryTestModeDataAccessInterface();
    private final InMemoryModeSelectionDataAccessObject modeSelectionDataAccessInterface = new InMemoryModeSelectionDataAccessObject();
    private final InMemoryTestResultDataAccessObject testResultDataAccessObject = new InMemoryTestResultDataAccessObject();

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private ModeSelectionViewModel modeSelectionViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private StudyModeView studyModeView;
    private StudyModeViewModel studyModeViewModel;
    private StudyModeBeginView studyModeBeginView;
    private StudyModeBeginViewModel studyModeBeginViewModel;
    private StudyModeQuestionView studyModeQuestionView;
    private StudyModeQuestionViewModel studyModeQuestionViewModel;
    private TestModeView testModeView;
    private TestModeViewModel testModeViewModel;
    private TestresultViewModel testresultViewModel;
    private TestresultView testresultView;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        modeSelectionViewModel = new ModeSelectionViewModel();
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    /**
     * Adds the Study Mode View to the application.
     * @return this builder
     */
    public AppBuilder addStudyModeView() {
        studyModeViewModel = new StudyModeViewModel();
        studyModeView = new StudyModeView(studyModeViewModel);
        cardPanel.add(studyModeView, studyModeView.getViewName());
        return this;
    }

    /**
     * Adds the Study Mode Begin View to the application.
     * @return this builder
     */
    public AppBuilder addStudyModeBeginView() {
        studyModeBeginViewModel = new StudyModeBeginViewModel();
        studyModeBeginView = new StudyModeBeginView(studyModeBeginViewModel);
        cardPanel.add(studyModeBeginView, studyModeBeginView.getViewName());
        return this;
    }

    /**
     * Adds the Study Mode Question View to the application.
     * @return this builder
     */
    public AppBuilder addStudyModeQuestionView() {
        studyModeQuestionViewModel = new StudyModeQuestionViewModel();
        studyModeQuestionView = new StudyModeQuestionView(studyModeQuestionViewModel);
        cardPanel.add(studyModeBeginView, studyModeBeginView.getViewName());
        return this;
    }

    /**
     * Adds the Test Mode View to the application.
     * @return this builder
     */
    public AppBuilder addTestModeView() {
        testModeViewModel = new TestModeViewModel();
        testModeView = new TestModeView(testModeViewModel);
        cardPanel.add(testModeView, testModeView.getViewName());
        return this;
    }

    /**
     * Add the test result View to the application.
     * @return this builder
     */
    public AppBuilder addTestResultView() {
        testresultViewModel = new TestresultViewModel();
        testresultView = new TestresultView(testresultViewModel);
        cardPanel.add(testresultView, testresultView.getViewName());
        return this;
    }

    /**
     * Adds the Signup Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(signupViewModel, viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds the Logged In (Mode Selection) Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoggedInUseCase() {
        final ModeSelectionOutputBoundary modeSelectionOutputBoundary = new ModeSelectionPresenter(viewManagerModel, modeSelectionViewModel);
        final ModeSelectionInputBoundary modeSelectionInteractor = new ModeSelectionInteractor(
                modeSelectionDataAccessInterface, modeSelectionOutputBoundary);

        final ModeSelectionController modeSelectionController = new ModeSelectionController(modeSelectionInteractor);
        loggedInView.setModeSelectionController(modeSelectionController);
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addChangePasswordUseCase() {
        final ChangePasswordOutputBoundary changePasswordOutputBoundary =
                new ChangePasswordPresenter(loggedInViewModel);

        final ChangePasswordInputBoundary changePasswordInteractor =
                new ChangePasswordInteractor(userDataAccessObject, changePasswordOutputBoundary, userFactory);

        final ChangePasswordController changePasswordController =
                new ChangePasswordController(changePasswordInteractor);
        loggedInView.setChangePasswordController(changePasswordController);
        return this;
    }

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(userDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        loggedInView.setLogoutController(logoutController);
        return this;
    }

    /**
     * Adds the Study Mode Use Case to the application.
     * @return this builder
     */
    public AppBuilder addStudyModeUseCase() {
        final StudyModeOutputBoundary studyModeOutputBoundary = new StudyModePresenter(viewManagerModel,
                studyModeViewModel, studyModeBeginViewModel, modeSelectionViewModel);

        final StudyModeInputBoundary studyModeInteractor =
                new StudyModeInteractor(studyModeDataAccessInterface, studyModeOutputBoundary);

        final StudyModeController studyModeController = new StudyModeController(studyModeInteractor);
        studyModeView.setStudyModeController(studyModeController);
        return this;
    }

    /**
     * Adds the Study Mode Begin Use Case to the application.
     * @return this builder
     */
    public AppBuilder addStudyModeBeginUseCase() {
        final StudyModeBeginOutputBoundary studyModeBeginOutputBoundary = new StudyModeBeginPresenter(viewManagerModel,
                studyModeBeginViewModel, studyModeQuestionViewModel);

        final StudyModeBeginInputBoundary studyModeBeginInteractor =
                new StudyModeBeginInteractor(studyModeBeginDataAccessInterface, studyModeBeginOutputBoundary);

        final StudyModeBeginController studyModeBeginController = new StudyModeBeginController(studyModeBeginInteractor);
        studyModeBeginView.setStudyModeBeginController(studyModeBeginController);
        return this;
    }

    /**
     * Adds the Test Mode Use Case to the application.
     * @return this builder
     */
    public AppBuilder addTestModeUseCase() {
        final TestModeOutputBoundary testModeOutputBoundary = new TestModePresenter(viewManagerModel,
                testModeViewModel);

        final TestModeInputBoundary testModeInteractor =
                new TestModeInteractor(testModeOutputBoundary);

        final TestModeController testModeController = new TestModeController(testModeInteractor);
        testModeView.setTestModeController(testModeController);
        return this;
    }

    /**
     * Adds the test result use case to the application.
     * @return this builder.
     */
    public AppBuilder addTestresultUseCase() {
        final TestresultOutputBoundary testresultOutputBoundary = new TestresultPresenter(testresultViewModel,
                loggedInViewModel, viewManagerModel);

        final TestresultInputBoundary testresultInteractor =
                new TestresultInteractor(testResultDataAccessObject, testresultOutputBoundary);

        final TestresultController testresultController = new TestresultController(testresultInteractor);
        testresultView.setTestResultController(testyModeDataAccessInterface, testresultController);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("GearUp");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}

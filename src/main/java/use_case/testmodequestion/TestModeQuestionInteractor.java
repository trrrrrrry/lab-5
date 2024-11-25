package use_case.testmodequestion;

/**
 * The TestModeQuestion Interactor
 */
public class TestModeQuestionInteractor implements TestModeQuestionInputBoundary {
    private final TestModeQuestionDataAccessInterface tmqdaiObject;
    private final TestModeQuestionOutputBoundary presenter;

    public TestModeQuestionInteractor(TestModeQuestionDataAccessInterface tmqdaiObject,
                                       TestModeQuestionOutputBoundary output) {
        this.tmqdaiObject = tmqdaiObject;
        this.presenter = output;
    }

    @Override
    public void execute(TestModeQuestionInputData input) {
        final String option = input.getSelectedAnswer();

        //        necessary?
        //        if (!isValidMode(mode)) {
        //            presenter.prepareFailView("Invalid answer selected, Please choose one of the fourth option");
        //        }
        final TestModeQuestionOutputData output = new TestModeQuestionOutputData(option);

        presenter.prepareSuccessView(output);
    }

    @Override
    public void switchToNextQuestionView() {
        presenter.switchToNextQuestionView();
    }

    @Override
    public void switchToTestResultView() {
        presenter.switchToTestResultView();
    }
}

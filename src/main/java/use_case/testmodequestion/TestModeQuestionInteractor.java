package use_case.testmodequestion;

import java.util.ArrayList;

/**
 * The TestModeQuestion Interactor.
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
    public void execute(TestModeQuestionInputData testModeQuestionInputData) {
        //        final String option = testModeQuestionInputData.getSelectedAnswer();
        final int correctnumber = testModeQuestionInputData.getCorrectAnswer();
        final ArrayList<String> wrongquestions = testModeQuestionInputData.getWrongquestions();

        //                necessary?
        //                if (!isValidMode(mode)) {
        //                    presenter.prepareFailView("Invalid answer selected,
        //                    Please choose one of the fourth option");
        //                }
        final TestModeQuestionOutputData output = new TestModeQuestionOutputData(correctnumber, wrongquestions);

        presenter.prepareSuccessView(output);
    }

    @Override
    public void switchToTestResultView() {
        presenter.switchToTestResultView();
    }
}

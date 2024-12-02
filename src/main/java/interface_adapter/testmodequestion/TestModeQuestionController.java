package interface_adapter.testmodequestion;

import use_case.testmodequestion.TestModeQuestionInputBoundary;
import use_case.testmodequestion.TestModeQuestionInputData;

/**
 * The controller for test mode question use case.
 */
public class TestModeQuestionController {
    private static TestModeQuestionInputBoundary tmqInteractor;

    public TestModeQuestionController(TestModeQuestionInputBoundary testModeQuestionInteractor) {
        this.tmqInteractor = testModeQuestionInteractor;
    }

    /**
     * Execute the test mode question use case.
     * @param option the option that the user selected.
     */
    public void execute(String option) {
        final TestModeQuestionInputData input = new TestModeQuestionInputData(option);
        tmqInteractor.execute(input);
    }

    /**
     * Execute the "switch to next question View" use case.
     */
    public void switchToNextQuestionView() {
        tmqInteractor.switchToNextQuestionView();
    }

    /**
     * Execute the "switch to Test Result View" use case.
     */
    public static void switchToTestResultView() {
        tmqInteractor.switchToTestResultView();
    }
}

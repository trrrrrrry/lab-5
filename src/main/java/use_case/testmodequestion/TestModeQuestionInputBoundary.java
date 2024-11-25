package use_case.testmodequestion;

/**
 * Input Boundary for actions which are related to study mode question.
 */
public interface TestModeQuestionInputBoundary {

    /**
     * Executes the TestModeQuestion use case.
     * @param TestModeQuestionInputData the input data
     */
    void execute(TestModeQuestionInputData TestModeQuestionInputData);

    /**
     * Switch to next Question View.
     */
    void switchToNextQuestionView();

    /**
     * Switch to the TestResult(?) View.
     */
    void switchToTestResultView();
}


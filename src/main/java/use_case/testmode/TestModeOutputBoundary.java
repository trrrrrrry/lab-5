package use_case.testmode;

/**
 * The output boundary for the Test Mode Use Case.
 */
public interface TestModeOutputBoundary {

    /**
     * Prepares the success view for the Test Mode Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(TestModeOutputData outputData);

    /**
     * Prepares the failure view for the Test Mode Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switch to the Study Mode Begin View.
     */
    void switchToTestModeQuestionView();
}

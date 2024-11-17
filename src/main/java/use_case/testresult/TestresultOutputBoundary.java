package use_case.testresult;

import use_case.testresult.TestresultOutputData;

/**
 * The output boundary for the Login Use Case.
 */
public interface TestresultOutputBoundary {
    /**
     * Prepares the success view for the test result Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(TestresultOutputData outputData);

    /**
     * Prepares the failure view for the test result Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switch to mode selection view.
     */
    void switchToModeselectionView();
}

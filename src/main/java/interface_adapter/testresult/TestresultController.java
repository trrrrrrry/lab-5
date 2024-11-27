package interface_adapter.testresult;

import java.util.ArrayList;

import use_case.testresult.TestresultInputBoundary;
import use_case.testresult.TestresultInputData;

/**
 * Controller for test result use case.
 */
public class TestresultController {
    private final TestresultInputBoundary testresultInteractor;

    public TestresultController(TestresultInputBoundary testresultInteractor) {
        this.testresultInteractor = testresultInteractor;
    }

    /**
     * Execute the Test result use case.
     * @param correctQuestions number of correct questions got
     * @param time time taken by the user for this test
     * @param incorrectQuestions a list of incorrect questions user got for this test
     */
    public void execute(int correctQuestions, int time, ArrayList<String> incorrectQuestions) {
        final TestresultInputData inputData = new TestresultInputData(correctQuestions, time, incorrectQuestions);
        testresultInteractor.execute(inputData);
    }

    /**
     * Execute the "switch to modeselectionView" use case.
     */
    public void switchToLoggedInView() {
        testresultInteractor.switchToLoggedInView();
    }
}

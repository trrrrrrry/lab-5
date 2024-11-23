package use_case.testresult;

/**
 * This is an interactor for test result use case.
 */
public class TestresultInteractor implements TestresultInputBoundary {
    private TestresultDataAccessInterface testresultDataAccessObject;
    private TestresultOutputBoundary testresultPresenter;

    public TestresultInteractor(TestresultDataAccessInterface testresultDataAccessInterface,
                                TestresultOutputBoundary testresultOutputBoundary) {
        this.testresultDataAccessObject = testresultDataAccessInterface;
        this.testresultPresenter = testresultOutputBoundary;
    }

    @Override
    public void execute(TestresultInputData testresultInputData) {
        // Validate the input data
        if (!isValid(testresultInputData)) {
            testresultPresenter.prepareFailView("Invalid test result provided");
        }

        // If the input is valid, proceed with prepare success view.
        final TestresultOutputData outputData = new TestresultOutputData(testresultInputData.getCorrectQuestions(),
                testresultInputData.getTime(), testresultInputData.getIncorrectQuestions());
        testresultPresenter.prepareSuccessView(outputData);
    }

    @Override
    public void switchToModeselectionView() {
        testresultPresenter.switchToModeselectionView();
    }

    // Private method to validate the input data
    private boolean isValid(TestresultInputData testresultInputData) {
        return testresultInputData.getCorrectQuestions() >= 0
                | testresultInputData.getTime() > 0 | testresultInputData.getIncorrectQuestions() != null;
    }
}

package use_case.testmode;

/**
 * The Test Mode Interactor.
 */
public class TestModeInteractor implements TestModeInputBoundary {
    private final TestModeDataAccessInterface testModeDataAccessInterface;
    private final TestModeOutputBoundary testModeOutputBoundary;

    public TestModeInteractor(TestModeDataAccessInterface testModeDataAccessInterface1,
                              TestModeOutputBoundary testModeOutputBoundary1) {
        this.testModeDataAccessInterface = testModeDataAccessInterface1;
        this.testModeOutputBoundary = testModeOutputBoundary1;
    }

    @Override
    public void execute(TestModeInputData testModeInputData) {
        final TestModeOutputData outputData = new TestModeOutputData();
        testModeOutputBoundary.prepareSuccessView(outputData);
    }

    @Override
    public void switchToTestModeQuestionView() {
        testModeOutputBoundary.switchToTestModeQuestionView();
    }
}

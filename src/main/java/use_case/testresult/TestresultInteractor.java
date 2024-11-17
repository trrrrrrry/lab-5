package use_case.testresult;

public class TestresultInteractor implements TestresultInputBoundary{
    private TestresultDataAccessInterface testresultDataAccessObject;
    private TestresultOutputBoundary testresultPresenter;

    public TestresultInteractor(TestresultDataAccessInterface testresultDataAccessInterface,
                                TestresultOutputBoundary testresultOutputBoundary) {
        this.testresultDataAccessObject = testresultDataAccessInterface;
        this.testresultPresenter = testresultOutputBoundary;
    }

    @Override
    public void execute(TestresultInputData testresultInputData) {
        final TestresultOutputData outputData = new TestresultOutputData(testresultInputData.getCorrectQuestions(),
                testresultInputData.getTime(), testresultInputData.getIncorrectQuestions());
        testresultPresenter.prepareSuccessView(outputData);

    }

    @Override
    public void switchToModeselectionView() {
        testresultPresenter.switchToModeselectionView();
    }
}

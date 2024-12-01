package use_case.testmode;

import use_case.studymode.StudyModeDataAccessInterface;

/**
 * The Test Mode Interactor.
 */
public class TestModeInteractor implements TestModeInputBoundary {
    private final TestModeDataAccessInterface testModeDataAccessInterface;
    private final TestModeOutputBoundary testModeOutputBoundary;

    public TestModeInteractor(TestModeDataAccessInterface testModeDataAccessInterface, TestModeOutputBoundary testModeOutputBoundary) {
        this.testModeDataAccessInterface = testModeDataAccessInterface;
        this.testModeOutputBoundary = testModeOutputBoundary;
    }

    @Override
    public void execute() {
        testModeOutputBoundary.prepareSuccessView();
    }

    @Override
    public void switchToTestModeQuestionView() {
        testModeOutputBoundary.switchToTestModeQuestionView();
    }

    @Override
    public void switchToModeSelectionView() {
        testModeOutputBoundary.switchToModeSelectionView();
    }
}

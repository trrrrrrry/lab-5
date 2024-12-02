package interface_adapter.testmode;

import use_case.testmode.TestModeInputBoundary;
import use_case.testmode.TestModeInputData;

/**
 * Controller for the Test Mode Use Case.
 */
public class TestModeController {
    private final TestModeInputBoundary testModeInputBoundary;

    public TestModeController(TestModeInputBoundary testModeInputBoundary) {
        this.testModeInputBoundary = testModeInputBoundary;
    }

    /**
     * Executes the Test Mode Use Case.
     */
    public void execute() {
        final TestModeInputData testModeInputData = new TestModeInputData();

        testModeInputBoundary.execute(testModeInputData);
    }

    /**
     * Executes the "switch to TestModeQuestion" Use Case.
     */
    public void switchToTestModeQuestionView() {
        testModeInputBoundary.switchToTestModeQuestionView();
    }

    /**
     * Executes the "switch to ModeSelection" Use Case.
     */
    public void switchToModeSelectionView() {
        testModeInputBoundary.switchToModeSelectionView();
    }
}

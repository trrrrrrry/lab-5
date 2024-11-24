package use_case.testmodequestion;

/**
 * InputData for the TestModeQuestion Use Case.
 */
public class TestModeQuestionInputData {
    private final String selectedAnswer;

    public TestModeQuestionInputData(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }
}

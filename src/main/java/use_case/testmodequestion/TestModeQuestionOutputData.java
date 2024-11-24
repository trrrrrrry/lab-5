package use_case.testmodequestion;

/**
 * Output Data for the Test Mode Question Use Case.
 */
public class TestModeQuestionOutputData {
    private final String option;

    /**
     * Constructs a StudyModeQuestionOutputData object with the selected option and confirmation message.
     * @param selectedOption The mode that was selected by the user.
     */
    public TestModeQuestionOutputData(String selectedOption) {
        this.option = selectedOption;
    }

    /**
     * Gets the selected option.
     * @return The option selected by the user as a String.
     */
    public String getSelectedMode() {
        return option;
    }
}

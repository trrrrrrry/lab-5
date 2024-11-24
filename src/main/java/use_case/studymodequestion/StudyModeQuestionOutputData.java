package use_case.studymodequestion;

/**
 * Output Data for the Study Mode Question Use Case.
 */
public class StudyModeQuestionOutputData {
    private final String option;

    /**
     * Constructs a StudyModeQuestionOutputData object with the selected option and confirmation message.
     * @param selectedOption The mode that was selected by the user.
     */
    public StudyModeQuestionOutputData(String selectedOption) {
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

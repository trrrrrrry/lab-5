package use_case.testmodequestion;

/**
 * This save the option selected for future use.
 */
public interface TestModeQuestionDataAccessInterface {

    /**
     * Save the specific option selected.
     * @param option The selected option to be saved, represented as a String.
     */
    void saveSelectedOption(String option);

    /**
     * Get the current selected option.
     * @return current option
     */
    String getSelectedOption();
}

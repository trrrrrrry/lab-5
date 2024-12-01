package data_access;

import use_case.testmodequestion.TestModeQuestionDataAccessInterface;

public class InMemoryTestModeQuestionDataAccessInterface implements TestModeQuestionDataAccessInterface {

    private String option;

    /**
     * Save the specific option selected.
     *
     * @param option The selected option to be saved, represented as a String.
     */
    @Override
    public void saveSelectedOption(String option) {
        this.option = option;
    }

    /**
     * Get the current selected option.
     *
     * @return current option
     */
    @Override
    public String getSelectedOption() {
        return this.option;
    }
}

package interface_adapter.testmodequestion;

/**
 * The state for the test mode question view model.
 */
public class TestModeQuestionState {
    private String selectedOption = "";

    /**
     * Get the option selected by the user.
     * @return selected option
     */
    public String getSelectedOption() {
        return selectedOption;
    }

    /**
     * Set a option.
     * @param selectedOption the option that is set.
     */
    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

}

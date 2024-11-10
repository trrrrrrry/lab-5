package use_case.modeselection;

/**
 * Output Data for the Mode Selection Use Case.
 */
public class ModeSelectionOutputData {

    private final String selectedMode;
    private final String confirmationMessage;

    /**
     * Constructs a ModeSelectionOutputData object with the selected mode and confirmation message.
     * @param selectedMode The mode that was selected by the user.
     * @param confirmationMessage A message confirming the selected mode.
     */
    public ModeSelectionOutputData(String selectedMode, String confirmationMessage) {
        this.selectedMode = selectedMode;
        this.confirmationMessage = confirmationMessage;
    }

    /**
     * Gets the selected mode.
     *
     * @return The mode selected by the user as a String.
     */
    public String getSelectedMode() {
        return selectedMode;
    }

    /**
     * Gets the confirmation message.
     *
     * @return A confirmation message as a String.
     */
    public String getConfirmationMessage() {
        return confirmationMessage;
    }
}

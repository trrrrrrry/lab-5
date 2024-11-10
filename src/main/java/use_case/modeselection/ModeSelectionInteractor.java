package use_case.modeselection;

import entity.User;

/**
 * The Mode Selection Interactor.
 */
public class ModeSelectionInteractor implements ModeSelectionInputBoundary {
    private final ModeSelectionOutputBoundary outputBoundary;

    public ModeSelectionInteractor(ModeSelectionOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(ModeSelectionInputData inputData) {
        String mode = inputData.getSelectedMode();
        String confirmationMessage = "You have selected " + mode;

        // Create output data
        ModeSelectionOutputData outputData = new ModeSelectionOutputData(mode, confirmationMessage);

        // Call the output boundary to present the result
        outputBoundary.presentModeSelection(outputData);
    }
}

package use_case.modeselection;

/**
 * The output boundary for the Mode Selection Use Case.
 */
public interface ModeSelectionOutputBoundary {
    /**
     * This is the present mode selection.
     * @param outputData is the present mode selection
     */
    void presentModeSelection(ModeSelectionOutputData outputData);
}


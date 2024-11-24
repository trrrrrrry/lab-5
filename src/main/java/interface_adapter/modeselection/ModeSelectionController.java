package interface_adapter.modeselection;

import use_case.modeselection.ModeSelectionInputBoundary;
import use_case.modeselection.ModeSelectionInputData;

/**
 * The controller for mode selection use case.
 */
public class ModeSelectionController {
    private final ModeSelectionInputBoundary modeSelectionInteractor;

    public ModeSelectionController(ModeSelectionInputBoundary modeSelectionInteractor) {
        this.modeSelectionInteractor = modeSelectionInteractor;
    }

    /**
     * Execute the mode selection use case.
     * @param module the mode that the user selected.
     */
    public void execute(String module) {
        final ModeSelectionInputData modeSelectionInputData = new ModeSelectionInputData(module);
        modeSelectionInteractor.execute(modeSelectionInputData);
    }

    /**
     * Execute the "switch to Study Mode View" use case.
     */
    public void switchToStudyModeView() {
        modeSelectionInteractor.switchToStudyModeView();
    }

    /**
     * Execute the "switch to Test Mode View" use case.
     */
    public void switchToTestModeView() {
        modeSelectionInteractor.switchToTestModeView();
    }
}

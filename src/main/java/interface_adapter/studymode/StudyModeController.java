package interface_adapter.studymode;

import use_case.studymode.StudyModeInputBoundary;

/**
 * Controller for the StudyMode Use Case.
 */
public class StudyModeController {
    private final StudyModeInputBoundary studyModeInputBoundary;

    public StudyModeController(StudyModeInputBoundary studyModeInputBoundary) {
        this.studyModeInputBoundary = studyModeInputBoundary;
    }

    /**
     * Executes the "switch to StudyModeBegin" Use Case.
     */
    public void switchToStudyModeBeginView() {
        studyModeInputBoundary.switchToStudyModeBeginView();
    }
}

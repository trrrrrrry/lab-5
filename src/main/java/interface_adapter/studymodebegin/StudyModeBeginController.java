package interface_adapter.studymodebegin;

import use_case.studymodebegin.StudyModeBeginInputBoundary;

/**
 * The controller for the Study Mode Use Case.
 */
public class StudyModeBeginController {

    private final StudyModeBeginInputBoundary studyModeBeginInputBoundary;

    public StudyModeBeginController(StudyModeBeginInputBoundary studyModeBeginInputBoundary) {
        this.studyModeBeginInputBoundary = studyModeBeginInputBoundary;
    }

    /**
     * Executes the "switch to StudyModeBegin" Use Case.
     */
    public void switchToStudyModeQuestionView() {
        studyModeBeginInputBoundary.switchToStudyModeQuestionView();
    }
}

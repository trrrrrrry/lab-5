package interface_adapter.studymodequestion;

import use_case.studymodequestion.StudyModeQuestionInputBoundary;
import use_case.studymodequestion.StudyModeQuestionInputData;

/**
 * The controller for study mode question use case.
 */
public class StudyModeQuestionController {
    private final StudyModeQuestionInputBoundary smqInteractor;

    public StudyModeQuestionController(StudyModeQuestionInputBoundary studyModeQuestionInteractor) {
        this.smqInteractor = studyModeQuestionInteractor;
    }

    /**
     * Execute the study mode question use case.
     * @param option the option that the user selected.
     */
    public void execute(String option) {
        final StudyModeQuestionInputData input = new StudyModeQuestionInputData(option);
        smqInteractor.execute(input);
    }

    /**
     * Execute the "switch to next question View" use case.
     */
    public void switchToNextQuestionView() {
        smqInteractor.switchToNextQuestionView();
    }

    /**
     * Execute the "switch to Test Result View" use case.
     */
    public void switchToTestResultView() {
        smqInteractor.switchToTestResultView();
    }
}

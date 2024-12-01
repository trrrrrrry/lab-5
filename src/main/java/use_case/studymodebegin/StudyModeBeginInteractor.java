package use_case.studymodebegin;

/**
 * The Study Mode Begin Interactor.
 */
public class StudyModeBeginInteractor implements StudyModeBeginInputBoundary {
    private final StudyModeBeginDataAccessInterface studyModeBeginDataAccessInterface;
    private final StudyModeBeginOutputBoundary studyModeBeginOutputBoundary;

    public StudyModeBeginInteractor(StudyModeBeginDataAccessInterface studyModeBeginDataAccessInterface,
                                    StudyModeBeginOutputBoundary studyModeBeginOutputBoundary) {
        this.studyModeBeginDataAccessInterface = studyModeBeginDataAccessInterface;
        this.studyModeBeginOutputBoundary = studyModeBeginOutputBoundary;
    }


    @Override
    public void execute(StudyModeBeginInputData studyModeBeginInputData) {
        final String module = studyModeBeginInputData.getModule();
        studyModeBeginDataAccessInterface.setModule(module);
        final StudyModeBeginOutputData outputData = new StudyModeBeginOutputData(module);
        studyModeBeginOutputBoundary.prepareSuccessView(outputData);
    }

    @Override
    public void switchToStudyModeQuestionView() {
        studyModeBeginOutputBoundary.switchToStudyModeQuestionView();
    }

    @Override
    public void switchToStudyModeView() {
        studyModeBeginOutputBoundary.switchToStudyModeView();
    }
}

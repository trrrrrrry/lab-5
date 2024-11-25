package use_case.studymode;

/**
 * The Study Mode Interactor.
 */
public class StudyModeInteractor implements StudyModeInputBoundary {
    private final StudyModeDataAccessInterface studyModeDataAccessInterface;
    private final StudyModeOutputBoundary studyModeOutputBoundary;

    public StudyModeInteractor(StudyModeDataAccessInterface studyModeDataAccessInterface,
                               StudyModeOutputBoundary studyModeOutputBoundary) {
        this.studyModeDataAccessInterface = studyModeDataAccessInterface;
        this.studyModeOutputBoundary = studyModeOutputBoundary;
    }

    @Override
    public void execute(StudyModeInputData studyModeInputData) {
        final String module = studyModeInputData.getModule();
        studyModeDataAccessInterface.setModule(module);
        final StudyModeOutputData outputData = new StudyModeOutputData(module);
        studyModeOutputBoundary.prepareSuccessView(outputData);
    }

    @Override
    public void switchToStudyModeBeginView() {
        studyModeOutputBoundary.switchToStudyModeBeginView();
    }
}

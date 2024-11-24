package interface_adapter.studymodebegin;

import interface_adapter.ViewManagerModel;
import use_case.studymodebegin.StudyModeBeginOutputBoundary;
import use_case.studymodebegin.StudyModeBeginOutputData;

/**
 * The Presenter for the Study Mode Begin Use Case.
 */
public class StudyModeBeginPresenter implements StudyModeBeginOutputBoundary {

    private ViewManagerModel viewManagerModel;
    private StudyModeBeginViewModel studyModeBeginViewModel;

    public StudyModeBeginPresenter(ViewManagerModel viewManagerModel, StudyModeBeginViewModel studyModeBeginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.studyModeBeginViewModel = studyModeBeginViewModel;
    }

    @Override
    public void prepareSuccessView(StudyModeBeginOutputData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }

    @Override
    public void switchToStudyModeQuestionView() {

    }
}

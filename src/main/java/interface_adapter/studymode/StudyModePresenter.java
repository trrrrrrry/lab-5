package interface_adapter.studymode;

import interface_adapter.ViewManagerModel;
import interface_adapter.studymodebegin.StudyModeBeginState;
import interface_adapter.studymodebegin.StudyModeBeginViewModel;
import use_case.studymode.StudyModeOutputBoundary;
import use_case.studymode.StudyModeOutputData;

/**
 * The Presenter for the Study Mode Use Case.
 */
public class StudyModePresenter implements StudyModeOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private StudyModeViewModel studyModeViewModel;
    private StudyModeBeginViewModel studyModeBeginViewModel;

    public StudyModePresenter(ViewManagerModel viewManagerModel,
                              StudyModeViewModel studyModeViewModel,
                              StudyModeBeginViewModel studyModeBeginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.studyModeViewModel = studyModeViewModel;
        this.studyModeBeginViewModel = studyModeBeginViewModel;
    }

    @Override
    public void prepareSuccessView(StudyModeOutputData outputData) {
        // On success, switch to study mode begin view with the chosen module

        final StudyModeBeginState studyModeBeginState = studyModeBeginViewModel.getState();
        studyModeBeginState.setModule(outputData.getModule());
        this.studyModeBeginViewModel.setState(studyModeBeginState);
        this.studyModeBeginViewModel.firePropertyChanged();

        this.viewManagerModel.setState(studyModeBeginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // Assume no failure view
    }

    @Override
    public void switchToStudyModeBeginView() {
        viewManagerModel.setState(studyModeBeginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

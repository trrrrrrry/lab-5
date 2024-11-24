package interface_adapter.testresult;

import interface_adapter.ViewManagerModel;
import interface_adapter.modeselection.ModeSelectionViewModel;
import interface_adapter.testresult.TestresultViewModel;
import use_case.testresult.TestresultOutputBoundary;
import use_case.testresult.TestresultOutputData;

/**
 * Presenter for Test result use case.
 */
public class TestresultPresenter implements TestresultOutputBoundary {
    private final TestresultViewModel testresultViewModel;
    private final ModeSelectionViewModel modeSelectionViewModel;
    private final ViewManagerModel viewManagerModel;

    public TestresultPresenter(TestresultViewModel testResultViewModel, ModeSelectionViewModel modeSelectionViewModel,
                               ViewManagerModel viewManagerModel) {
        this.testresultViewModel = testResultViewModel;
        this.modeSelectionViewModel = modeSelectionViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(TestresultOutputData outputData) {
        testresultViewModel.setCorrectQuestions(outputData.getCorrectQuestions());
        testresultViewModel.setTime(outputData.getTime());
        testresultViewModel.setIncorrectQuestions(outputData.getIncorrectQuestions());
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final TestresultState testresultState = new TestresultState();
        testresultState.setTestResultError(errorMessage);
        testresultViewModel.firePropertyChanged();
    }

    @Override
    public void switchToModeselectionView() {
        viewManagerModel.setState(modeSelectionViewModel.getViewName());
    }

}

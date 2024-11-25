package interface_adapter.testmodequestion;

import interface_adapter.ViewManagerModel;
import use_case.testmodequestion.TestModeQuestionOutputBoundary;
import use_case.testmodequestion.TestModeQuestionOutputData;

/**
 * Presenter for Test Mode Question use case.
 */
public class TestModeQuestionPresenter implements TestModeQuestionOutputBoundary {
    private final TestModeQuestionViewModel testModeQuestionViewModel;
    private final ViewManagerModel viewManagerModel;

    public TestModeQuestionPresenter(ViewManagerModel viewManagerModel, TestModeQuestionViewModel testModeQuestionViewModel) {
        this.testModeQuestionViewModel = testModeQuestionViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(TestModeQuestionOutputData output) {
        // TODO: haven't change yet
        testModeQuestionViewModel.getState().setSelectedOption(output.getSelectedMode());

        viewManagerModel.setState(output.getSelectedMode());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // assume there is no failure case when selecting a mode.
    }

    @Override
    public void switchToNextQuestionView() {
        // TODO : change needed
        viewManagerModel.setState("next question");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToTestResultView() {
        viewManagerModel.setState("test result");
        viewManagerModel.firePropertyChanged();
    }
}


package interface_adapter.testmode;

import interface_adapter.ViewManagerModel;
// import interface_adapter.testmodequestion.TestModeQuestionState;
// import interface_adapter.testmodequestion.TestModeQuestionViewModel;
import interface_adapter.modeselection.ModeSelectionViewModel;
import use_case.testmode.TestModeOutputBoundary;
import use_case.testmode.TestModeOutputData;

/**
 * The Presenter for the Test Mode Use Case.
 */
public class TestModePresenter implements TestModeOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private TestModeViewModel testModeViewModel;
    private ModeSelectionViewModel modeSelectionViewModel;
    // private TestModeQuestionViewModel testModeQuestionViewModel;

    public TestModePresenter(ViewManagerModel viewManagerModel,
                             TestModeViewModel testModeViewModel,
                             ModeSelectionViewModel modeSelectionViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.testModeViewModel = testModeViewModel;
        this.modeSelectionViewModel = modeSelectionViewModel;
    }

    @Override
    public void prepareSuccessView(TestModeOutputData outputData) {
        // On success, switch to test mode question view

        final TestModeState testModeState = testModeViewModel.getState();
        this.testModeViewModel.setState(testModeState);
        this.testModeViewModel.firePropertyChanged();

        this.viewManagerModel.setState(testModeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // Assume no failure view
    }

    @Override
    public void switchToTestModeQuestionView() {
        viewManagerModel.setState(testModeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToModeSelectionView() {
        viewManagerModel.setState(modeSelectionViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

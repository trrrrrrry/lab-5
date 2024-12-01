package use_case.studymodebegin;

import data_access.InMemoryStudyModeBeginDataAccessInterface;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyModeBeginTest {

    @Test
    void successBeginTest() {

        // assume user selected module 1 to study
        StudyModeBeginInputData inputData = new StudyModeBeginInputData("Module 1");

        // Set up the In-Memory Data
        StudyModeBeginDataAccessInterface studyModeBeginDataAccessInterface = new InMemoryStudyModeBeginDataAccessInterface();

        // Create a ViewManagerModel to track the current view
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Set up a Success Presenter to check if the user is redirected to <StudyModeBeginView>
        // with the module name they selected. In this case, the module name is "Module 1".
        StudyModeBeginOutputBoundary successPresenter = new StudyModeBeginOutputBoundary() {

            @Override
            public void prepareSuccessView(StudyModeBeginOutputData outputData) {
                assertEquals("Module 1", outputData.getModule());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure while selecting module");
            }

            @Override
            public void switchToStudyModeQuestionView() {
                viewManagerModel.setState("study mode question");
                viewManagerModel.firePropertyChanged();
            }
        };

        // Create and execute the <StudyModeBegin> interactor
        StudyModeBeginInputBoundary interactor = new StudyModeBeginInteractor(studyModeBeginDataAccessInterface, successPresenter);
        interactor.execute(inputData);

        // Test if the module name was saved
        assertEquals("Module 1", studyModeBeginDataAccessInterface.getModule());

        // Test if the view is navigated successfully
        interactor.switchToStudyModeQuestionView();
        assertEquals("study mode question", viewManagerModel.getState());
    }

    @Test
    void failureIncorrectRedirectionTest() {
        // Create input data for selecting Module 1
        StudyModeBeginInputData inputData = new use_case.studymode.StudyModeBeginInputData("Module 1");

        // Set up Im-Memory Data Access and Output Boundary
        use_case.studymode.StudyModeBeginDataAccessInterface studymodeDataAccessInterface = new InMemoryStudyModeDataAccessInterface();
        StudyModeOutputBoundary failurePresenter = new StudyModeOutputBoundary() {
            @Override
            public void prepareSuccessView(StudyModeOutputData outputData) {
                // Simulate incorrect redirection by forcing an incorrect state
                assertNotEquals("Module 2", outputData.getModule());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure while selecting module.");
            }

            @Override
            public void switchToStudyModeBeginView() {
                // Not useful in this test
            }

            @Override
            public void switchToModeSelectionView() {
                // Not useful in this test
            }
        };

        // Create the <StudyModeInteractor> and execute the selection
        StudyModeInputBoundary interactor = new StudyModeInteractor(studymodeDataAccessInterface, failurePresenter);
        interactor.execute(inputData);
    }


    @Test
    void failureInvalidModuleTest() {
        // Create input data for selecting Module 1
        use_case.studymode.StudyModeBeginInputData inputData = new use_case.studymode.StudyModeBeginInputData("Module 0");

        // Set up Im-Memory Data Access and Output Boundary
        use_case.studymode.StudyModeBeginDataAccessInterface studymodeDataAccessInterface = new InMemoryStudyModeDataAccessInterface();
        StudyModeOutputBoundary failurePresenter = new StudyModeOutputBoundary() {
            @Override
            public void prepareSuccessView(StudyModeOutputData response) {
                fail("Unexpected failure, success view was called when there is an invalid module.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Invalid module selected, Please choose from the following (Module 1 to 6)",
                        error);
            }

            @Override
            public void switchToStudyModeBeginView() {
                // Not useful in this test
            }

            @Override
            public void switchToModeSelectionView() {
                // Not useful in this test
            }
        };

        // Create the <StudyModeInteractor> and execute the selection
        StudyModeInputBoundary interactor = new StudyModeInteractor(studymodeDataAccessInterface, failurePresenter);
        interactor.execute(inputData);
    }
}

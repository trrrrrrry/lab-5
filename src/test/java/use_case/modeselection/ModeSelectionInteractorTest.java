package use_case.modeselection;

import org.junit.jupiter.api.Test;
import data_access.InMemoryModeSelectionDataAccessObject;

import static org.junit.jupiter.api.Assertions.*;

class ModeSelectionInteractorTest {

    @Test
    void successStudyModeSelectionTest() {
        //assume user selected Study mode
        ModeSelectionInputData inputData = new ModeSelectionInputData("study mode");

        // Set up the In-Memory Data
        ModeSelectionDataAccessInterface modeSelectionDataAccess = new InMemoryModeSelectionDataAccessObject();

        // set up a success presenter to see if the user is redirected to the mode they chose
        // in this case, the study mode
        ModeSelectionOutputBoundary successPresenter = new ModeSelectionOutputBoundary() {
            @Override
            public void prepareSuccessView(ModeSelectionOutputData outputData) {
                assertEquals("study mode", outputData.getSelectedMode());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure while selecting mode.");
            }

            @Override
            public void switchToStudyModeView() {

            }

            @Override
            public void switchToTestModeView() {

            }
        };

        // Create the ModeSelection Interactor and execute the selection.
        ModeSelectionInputBoundary interactor = new ModeSelectionInteractor(modeSelectionDataAccess, successPresenter);
        interactor.execute(inputData);

        // Test if the correct mode was saved
        assertEquals("study mode", modeSelectionDataAccess.getSelectedMode());
    }


    @Test
    void successTestModeSelectionTest() {
        //assume user selected Study mode
        ModeSelectionInputData inputData = new ModeSelectionInputData("test mode");

        // Set up the In-Memory Data
        ModeSelectionDataAccessInterface modeSelectionDataAccess = new InMemoryModeSelectionDataAccessObject();

        // set up a success presenter to see if the user is redirected to the mode they chose
        // in this case, the study mode
        ModeSelectionOutputBoundary successPresenter = new ModeSelectionOutputBoundary() {
            @Override
            public void prepareSuccessView(ModeSelectionOutputData outputData) {
                assertEquals("test mode", outputData.getSelectedMode());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure while selecting mode.");
            }

            @Override
            public void switchToStudyModeView() {
                // not used in a test
            }

            @Override
            public void switchToTestModeView() {
                // not used in a test
            }
        };

        // Create the ModeSelection Interactor and execute the selection.
        ModeSelectionInputBoundary interactor = new ModeSelectionInteractor(modeSelectionDataAccess, successPresenter);
        interactor.execute(inputData);

        // Test if the correct mode was saved
        assertEquals("test mode", modeSelectionDataAccess.getSelectedMode());
    }


    @Test
    void failureIncorrectRedirectionTest() {
        // Create Input Data for selecting Study Mode
        ModeSelectionInputData inputData = new ModeSelectionInputData("study mode");

        // Set up In-Memory Data Access and Output Boundary
        ModeSelectionDataAccessInterface modeSelectionDataAccess = new InMemoryModeSelectionDataAccessObject();
        ModeSelectionOutputBoundary failurePresenter = new ModeSelectionOutputBoundary() {
            @Override
            public void prepareSuccessView(ModeSelectionOutputData response) {
                // Simulate incorrect redirection by forcing an incorrect state
                assertNotEquals("test mode", response.getSelectedMode());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Unexpected failure while selecting mode.");
            }

            @Override
            public void switchToStudyModeView() {
                // not useful in a test
            }

            @Override
            public void switchToTestModeView() {
                // not useful in a test
            }
        };

        // Create the ModeSelectionInteractor and execute the selection
        ModeSelectionInputBoundary interactor = new ModeSelectionInteractor(modeSelectionDataAccess, failurePresenter);
        interactor.execute(inputData);
    }

}
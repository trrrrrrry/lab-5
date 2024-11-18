package use_case.testresult;

import data_access.InMemoryTestResultDataAccessObject;
import org.junit.jupiter.api.Test;
import use_case.testresult.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestResultInteractorTest {

    @Test
    void successAllCorrectTestResultTest() {
        ArrayList<String> incorrectQuestions = new ArrayList<>();
        TestresultInputData inputData = new TestresultInputData(40, 120, incorrectQuestions);

        TestresultDataAccessInterface testResultDataAccess = new InMemoryTestResultDataAccessObject();

        TestresultOutputBoundary successPresenter = new TestresultOutputBoundary() {
            @Override
            public void prepareSuccessView(TestresultOutputData outputData) {
                assertEquals(40, outputData.getCorrectQuestions());
                assertEquals(120, outputData.getTime());
                assertEquals(0, incorrectQuestions.size());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("value present on test result is not correct");
            }

            @Override
            public void switchToModeselectionView() {
                // no need to implement in a test
            }
        };
        TestresultInputBoundary interactor = new TestresultInteractor(testResultDataAccess, successPresenter);
        interactor.execute(inputData);

        assertEquals(40, testResultDataAccess.getCorrectQuestions());
        assertEquals(120, testResultDataAccess.getTime());
        assertEquals(0, testResultDataAccess.getIncorrectQuestions().size());
    }
}
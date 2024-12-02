package interface_adapter.testresult;

import java.util.ArrayList;

/**
 * State of Test Result use case.
 */
public class TestresultState {
    private int correctQuestions;
    private ArrayList<String> incorrectQuestions = new ArrayList<>();
    private String testResultError;

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

    public ArrayList<String> getIncorrectQuestions() {
        return incorrectQuestions;
    }

    public void setIncorrectQuestions(ArrayList<String> incorrectQuestions) {
        this.incorrectQuestions = incorrectQuestions;
    }

    public void setTestResultError(String testResultError) {
        this.testResultError = testResultError;
    }

}

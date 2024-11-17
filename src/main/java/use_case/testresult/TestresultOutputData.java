package use_case.testresult;

import java.util.ArrayList;

/**
 * Outputdata for Test Result use case.
 */
public class TestresultOutputData {
    private final int correctQuestions;
    private final int time;
    private final ArrayList<String> incorrectQuestions;

    public TestresultOutputData(int correctQuestions, int time, ArrayList<String> incorrectQuestions) {
        this.correctQuestions = correctQuestions;
        this.time = time;
        this.incorrectQuestions = incorrectQuestions;
    }

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public int getTime() {
        return time;
    }

    public ArrayList<String> getIncorrectQuestions() {
        return incorrectQuestions;
    }
}

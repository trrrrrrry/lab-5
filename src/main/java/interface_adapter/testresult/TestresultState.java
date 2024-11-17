package interface_adapter.testresult;

import java.util.ArrayList;

public class TestresultState {
    private int correctQuestions;
    private int time;
    private ArrayList<String> incorrectQuestions;

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<String> getIncorrectQuestions() {
        return incorrectQuestions;
    }

    public void setIncorrectQuestions(ArrayList<String> incorrectQuestions) {
        this.incorrectQuestions = incorrectQuestions;
    }

}

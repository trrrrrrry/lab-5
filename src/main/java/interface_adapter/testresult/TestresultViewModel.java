package interface_adapter.testresult;

import interface_adapter.ViewModel;

import java.util.ArrayList;

/**
 * The ViewModel for test result view.
 */
public class TestresultViewModel extends ViewModel<TestresultState> {
    public static final String TITLE_LABEL = "Test Result";

    public TestresultViewModel() {
        super("test result");
        setState(new TestresultState());
    }

    public int getCorrectQuestions() {
        return getState().getCorrectQuestions();
    }

    public void setCorrectQuestions(int correctQuestions) {
        getState().setCorrectQuestions(correctQuestions);
    }

    public int getTime() {
        return getState().getTime();
    }

    public void setTime(int time) {
        getState().setTime(time);
    }

    public ArrayList<String> getIncorrectQuestions() {
        return getState().getIncorrectQuestions();
    }

    public void setIncorrectQuestions(ArrayList<String> incorrectQuestions) {
        getState().setIncorrectQuestions(incorrectQuestions);
    }

}

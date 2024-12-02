package data_access;

import java.util.ArrayList;

import use_case.testmodequestion.TestModeQuestionDataAccessInterface;

/**
 * In memory test mode questions Data Access Interface.
 */
public class InMemoryTestModeQuestionDataAccessInterface implements TestModeQuestionDataAccessInterface {

    private String options;
    private int correctQuestions;
    private ArrayList<String> incorrectQuestions;

    /**
     * Save the specific option selected.
     *
     * @param option The selected option to be saved, represented as a String.
     */
    @Override
    public void saveSelectedOption(String option) {
        this.options = option;
    }

    /**
     * Get the current selected option.
     *
     * @return current option
     */
    @Override
    public String getSelectedOption() {
        return this.options;
    }

    @Override
    public int getCorrectQuestions() {
        return this.correctQuestions;
    }

    @Override
    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

    @Override
    public ArrayList<String> getIncorrectQuestions() {
        return incorrectQuestions;
    }

    @Override
    public void setIncorrectQuestions(ArrayList<String> incorrectQuestions) {
        this.incorrectQuestions = incorrectQuestions;
    }
}

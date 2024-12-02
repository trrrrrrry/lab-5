package use_case.testmodequestion;

import java.util.ArrayList;

/**
 * This save the option selected for future use.
 */
public interface TestModeQuestionDataAccessInterface {

    /**
     * Save the specific option selected.
     * @param option The selected option to be saved, represented as a String.
     */
    void saveSelectedOption(String option);

    /**
     * Get the current selected option.
     * @return current option
     */
    String getSelectedOption();

    /**
     * Get correct questions.
     * @return correct questions
     */
    int getCorrectQuestions();

    /**
     * Set correct questions.
     * @param correctQuestions correct questions
     */
    void setCorrectQuestions(int correctQuestions);

    /**
     * Get incorrect questions.
     * @return incorrect questions
     */
    ArrayList<String> getIncorrectQuestions();

    /**
     * Set incorrect questions.
     * @param incorrectQuestions incorrect questions
     */
    void setIncorrectQuestions(ArrayList<String> incorrectQuestions);
}

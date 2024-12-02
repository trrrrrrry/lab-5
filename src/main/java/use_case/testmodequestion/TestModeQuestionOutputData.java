package use_case.testmodequestion;

import java.util.ArrayList;

/**
 * Output Data for the Test Mode Question Use Case.
 */
public class TestModeQuestionOutputData {
//    private final String option;
    private int correctQuestions;
    private ArrayList<String> incorrectQuestions;

    /**
     * Constructs a StudyModeQuestionOutputData object with the selected option and confirmation message.
     * @param correctQuestions The number of correct questions.
     * @param wrongquestions The question text of wrong questions.
     */
    public TestModeQuestionOutputData(int correctQuestions, ArrayList<String> wrongquestions) {
        this.correctQuestions = correctQuestions;
        this.incorrectQuestions = wrongquestions;
    }

//    /**
//     * Gets the selected option.
//     * @return The option selected by the user as a String.
//     */
//    public String getSelectedMode() {
//        return option;
//    }

    /**
     * Get correct questions.
     * @return correct questions
     */
    public int getCorrectQuestions() {
        return correctQuestions;
    }

    /**
     * Get incorrect questions.
     * @return incorrect questions
     */
    public ArrayList<String> getIncorrectQuestions() {
        return incorrectQuestions;
    }

}

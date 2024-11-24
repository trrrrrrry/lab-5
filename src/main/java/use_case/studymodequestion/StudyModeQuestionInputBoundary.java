package use_case.studymodequestion;

/**
 * Input Boundary for actions which are related to study mode question.
 */
public interface StudyModeQuestionInputBoundary {

    /**
     * Executes the StudyModeQuestion use case.
     * @param studyModeQuestionInputDataInputData the input data
     */
    void execute(StudyModeQuestionInputData studyModeQuestionInputDataInputData);

    void switchToNextQuestionView();

    void switchToTestResult();
}
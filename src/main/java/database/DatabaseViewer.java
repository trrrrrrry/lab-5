package database;

import java.util.List;

import data_access.DatabaseRetriever;
import entity.Answer;
import entity.Question;

/**
 * A utility class to view and verify the data in the database by printing it to the console.
 */
public class DatabaseViewer {

    /**
     * Fetches all questions and answers from the database and prints them to the console.
     */
    public static void displayAllQuestions() {
        try {
            final List<Question> questions = DatabaseRetriever.getAllQuestions();

            for (Question question : questions) {
                System.out.println("Question ID: " + question.getId());
                System.out.println("Question Text: " + question.getQuestionText());

                for (Answer answer : question.getAnswers()) {
                    String answerText = " - Answer: " + answer.getAnswerText();
                    if (answer.isCorrect()) {
                        answerText += " (Correct)";
                    }
                    System.out.println(answerText);
                }
                System.out.println();
            }
        }
        catch (Exception databaseviewerexception) {
            databaseviewerexception.printStackTrace();
        }
    }

    /**
     * Display the all the questions with their options (and the correct answer) to test the database.
     *
     * @param args command-line arguments passed to the application (not used in this method).
     */
    public static void main(String[] args) {
        displayAllQuestions();
    }
}

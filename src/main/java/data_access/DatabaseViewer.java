package data_access;

import java.util.List;

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
            // Retrieve all questions with answers
            final List<Question> questions = DatabaseRetriever.getAllQuestions();

            // Iterate over questions and print details
            for (Question question : questions) {
                System.out.println("Question ID: " + question.getId());
                System.out.println("Question Text: " + question.getQuestionText());

                // Print each answer for the question
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

    public static void main(String[] args) {
        displayAllQuestions();
    }
}

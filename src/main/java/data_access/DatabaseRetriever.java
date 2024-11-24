package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Answer;
import entity.Question;

/**
 * Retrieves questions and ans`wers from the database.
 */
public class DatabaseRetriever {

    /**
     * Retrieves all questions from the database along with their answers.
     *
     * @return a list of Question objects with associated answers
     * @throws SQLException if a database access error occurs
     */
    public static List<Question> getAllQuestions() throws SQLException {
        final List<Question> questions = new ArrayList<>();
        final String query = "SELECT id, question_text FROM Questions";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                final int id = rs.getInt("id");
                final String questionText = rs.getString("question_text");
                final List<Answer> answers = getAllAnswersOnQ(id);

                // Create a Question object with its ID and answers
                final Question question = new Question(id, questionText, answers);
                questions.add(question);
            }
        }
        return questions;
    }

    /**
     * Retrieves all answers from the question object.
     *
     * @param questionID the ID of the question in which we are trying to find the answers.
     * @return a list of answer objects with associated question
     * @throws SQLException if a database access error occurs
     *
     */
    public static List<Answer> getAllAnswersOnQ(int questionID) throws SQLException {
        final List<Answer> answers = new ArrayList<>();

        final String query = "SELECT answer_text, is_correct FROM Answers WHERE question_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, questionID);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    final String answerText = rs.getString("answer_text");
                    final boolean isCorrect = rs.getBoolean("is_correct");

                    // Create an Answer object and add it to the list
                    final Answer answer = new Answer(answerText, isCorrect);
                    answers.add(answer);
                }
            }
        }
        catch (SQLException retrieverE) {
            retrieverE.printStackTrace();
            throw retrieverE;
        }

        return answers;
    }
}

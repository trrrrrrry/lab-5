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
 * Retrieves questions and answers from the database.
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
                // final int id = rs.getInt("id");
                final String questionText = rs.getString("question_text");

                // 创建 Question 对象，并加入到列表中
                final Question question = new Question(questionText);
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return questions;
    }
}

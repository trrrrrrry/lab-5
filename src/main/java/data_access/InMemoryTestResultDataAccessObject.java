package data_access;

import use_case.testresult.TestresultDataAccessInterface;

import java.util.ArrayList;

/**
 * In-memory implementation of the DAO for storing test result data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryTestResultDataAccessObject implements TestresultDataAccessInterface {
    private int correctQuestions;
    private int time;
    private ArrayList<String> incorrectQuestions = new ArrayList<>();

    @Override
    public int getCorrectQuestions() {
        return correctQuestions;
    }

    @Override
    public int getTime() {
        return time;
    }

    @Override
    public ArrayList<String> getIncorrectQuestions() {
        return incorrectQuestions;
    }
}

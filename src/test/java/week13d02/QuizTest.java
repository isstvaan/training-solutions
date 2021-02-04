package week13d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    static Quiz quiz = new Quiz();

    @BeforeAll
    static void init() {
        quiz.loadDatasFromFile(new BufferedReader(new InputStreamReader(Quiz.class.getResourceAsStream("results.txt"))));
    }

    @Test
    void testIsGoodAnswer() {
        assertEquals(true, quiz.isGoodAnswer("AB123", 0));
    }

    @Test
    void testGetMaxPassUserCode() {
        assertEquals("BD452", quiz.getMaxPassUserCode());
    }

    @Test
    void testGetWinner() {
        assertEquals("GH1234", quiz.getWinner());
    }
}
package jvm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TesterClassTest {

    @Test
    void getSortedList() {
        TesterClass tester = new TesterClass();
        List<Integer> testerList = tester.getSortedList(20);

        assertEquals(20, testerList.size());
        for (int i = 0; i < testerList.size() - 1; i++) {
            assertTrue(testerList.get(i) <= testerList.get(i + 1));
        }
    }
}
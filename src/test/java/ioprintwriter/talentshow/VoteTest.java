package ioprintwriter.talentshow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoteTest {

    private Vote v = new Vote(1, 10);

    @Test
    public void createVote() {
        assertEquals(1, v.getId());
        assertEquals(10, v.getNumber());
    }

    @Test
    public void incNumberTest() {
        assertEquals(10, v.getNumber());
        v.incNum();
        assertEquals(11, v.getNumber());
    }

}
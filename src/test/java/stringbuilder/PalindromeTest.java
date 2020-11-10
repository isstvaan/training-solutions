package stringbuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {

    @Test
    public void isPalindrome() {

        assertEquals(true, new Palindrome().isPalindrome("Racecar"));
        assertEquals(false, new Palindrome().isPalindrome("start"));
        assertEquals(true, new Palindrome().isPalindrome(""));
        assertEquals(true, new Palindrome().isPalindrome("\n\t"));
    }
}

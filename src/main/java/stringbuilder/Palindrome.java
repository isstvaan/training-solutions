package stringbuilder;

public class Palindrome {
    public boolean isPalindrome(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        string=string.trim();
        StringBuilder stringBuilder = new StringBuilder(string);
        return string.equalsIgnoreCase(stringBuilder.reverse().toString());
    }
}

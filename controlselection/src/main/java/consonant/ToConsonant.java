package consonant;

public class ToConsonant {
    public char ToConsonant(char charValue) {
        if ("aeuio".contains(Character.toString(charValue).toLowerCase())) {
            return (char) (charValue + 1);
        }
        return charValue;
    }
}

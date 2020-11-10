package stringbasic;

public class StringBasic {

    public String createStringForHeap() {
        return new String("text");
    }

    public String createStringForPool() {
        return "text";
    }
}

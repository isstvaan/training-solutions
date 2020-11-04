package whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {
        WhichType whichType = new WhichType();

        System.out.println(whichType.whichType(Long.toString(0)));
        System.out.println(whichType.whichType(Long.toString((long) Byte.MIN_VALUE)));
        System.out.println(whichType.whichType(Long.toString((long) Short.MIN_VALUE)));
        System.out.println(whichType.whichType(Long.toString((long) Integer.MIN_VALUE)));
        System.out.println(whichType.whichType(Long.toString(Long.MIN_VALUE)));
    }
}

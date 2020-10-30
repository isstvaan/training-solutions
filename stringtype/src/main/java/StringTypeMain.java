public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Wick";
        String message = prefix + name;

        System.out.println(message);

        message += 444;

        System.out.println(message);

        boolean b = message.equals("Hello John Wick");
        boolean c = message.equals("Hello John Wick444");

        System.out.println(("" + "").length());

        String tmp = "Abcde";

        System.out.println(tmp.length());
        System.out.println(tmp.substring(0, 1) + "," + tmp.substring(2, 3));

        System.out.println(tmp.substring(0, 3));

    }
}

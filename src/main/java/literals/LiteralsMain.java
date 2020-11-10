package literals;

public class LiteralsMain {
    public static void main(String[] args) {

        System.out.println("" + 1 + 2);

        System.out.println(Integer.toString(1) + Integer.toString(2));

        double quotient = 3 / 4;
        System.out.println(quotient); //0.0 egész osztva egésszel egészet ad vissza a maradékot eldobja

        quotient = 3 / 4d;
        System.out.println(quotient); //így már jó, egész osztva nem egésszel az nem egész lesz

        long big = 3_244_444_444L;

        System.out.println(big);

        String s = "árvíztűrőtükörfúrógép";
        System.out.println(s);

        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));
    }
}

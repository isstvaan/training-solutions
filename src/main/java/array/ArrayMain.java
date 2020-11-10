package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] weekDays = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};

        System.out.println("Tömb második eleme: " + weekDays[1]);
        System.out.println("Tömb hossza: " + weekDays.length);

        int[] powersOfTwo = new int[5];
        int powTmp=1;
        for (int i = 0; i < 5; i++) {
            powersOfTwo[i] =  powTmp;
            powTmp *=2;
        }

        String powersOfTwoString = "";
        for (int i = 0; i < 5; i++) {

            powersOfTwoString += powersOfTwo[i] + (i < powersOfTwo.length - 1 ? "," : "");
        }
        System.out.println("Kettő hatványai: " + powersOfTwoString);

        boolean[] testBooleans = new boolean[6];
        for (int i = 0; i < testBooleans.length; i++) {
            testBooleans[i] = i % 2 != 0;
        }

        System.out.println("Bool tömb tartalma: ");
        for (int i = 0; i < testBooleans.length; i++) {
            System.out.println(testBooleans[i]);
        }

    }
}

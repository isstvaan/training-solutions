package music;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Song song = new Song();

        System.out.println("Kérem adja meg a zeneszám előadóját:");
        song.band = scanner.nextLine();

        System.out.println("Kérem adja meg a zeneszám címét:");
        song.title = scanner.nextLine();

        System.out.println("Kérem adja meg a zeneszám hosszát (perc):");
        song.length = scanner.nextInt();

        System.out.println("\n" + song.band + " - " + song.title + " (" + song.length + " perc)");
    }
}

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Felhasználók listázása");
        System.out.println("2. Felhasználók felvétele");

        int selectedMenu = scanner.nextInt();

        System.out.println(selectedMenu == 1 ? "Felhasználók listázása" :
                            selectedMenu == 2 ? "Felhasználók felvétele" :
                                    "");

    }
}

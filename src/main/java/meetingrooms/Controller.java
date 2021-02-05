package meetingrooms;

import java.util.Scanner;

public class Controller {
    private Office office;
    private Scanner scanner = new Scanner(System.in);

    public void readOffice() {
        office = new Office();
        System.out.println("Hány darab tárgyalót szeretnél rögzíteni?");

        int numberOfMeetengRooms = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfMeetengRooms; i++) {
            System.out.println((i + 1) + " tárgyaló neve: ");
            String name = scanner.nextLine();
            System.out.println((i + 1) + " tárgyaló szélessége (méter): ");
            int width = scanner.nextInt();
            scanner.nextLine();
            System.out.println((i + 1) + "Tárgyaló hosszúsága (méter): ");
            int length = scanner.nextInt();
            scanner.nextLine();

            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }
    }

    public void printMenu() {
        System.out.println("MENÜ");
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
        System.out.println("0. Kilépés");
    }

    public void runMenu() {
        printMenu();

        int menuIndex = scanner.nextInt();
        scanner.nextLine();

        switch (menuIndex) {
            case 0:
                System.out.println("Viszont látásra");
                return;
            case 1:
                office.printNames();
                break;
            case 2:
                office.printNamesReverse();
                break;
            case 3:
                office.printEventNames();
                break;
            case 4:
                office.printAreas();
                break;
            case 5:
                System.out.println("Keresett tárgyaló neve:");
                office.printMeetingRoomsWithName(scanner.nextLine());
                break;
            case 6:
                System.out.println("Keresett tárgyaló nevének töredéke:");
                office.printMeetingRoomsContaint(scanner.nextLine());
                break;
            case 7:
                System.out.println("Keresett tárgyaló területe:");
                int area = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(area);
                break;
            default:
                System.out.println("Érvénytelen menüpont");
                break;
        }

        runMenu();
    }

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.readOffice();

        controller.runMenu();
    }
}

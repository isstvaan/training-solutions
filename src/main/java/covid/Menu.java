package covid;

import java.util.List;
import java.util.Scanner;

public class Menu {
    CovidDao dao;
    FileHandler fileHandler;
    UserInputHandler userInputHandler;

    public Menu(CovidDao dao, FileHandler fileHandler) {
        this.dao = dao;
        this.fileHandler = fileHandler;
        this.userInputHandler = new UserInputHandler();
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);

        mainMenu();

        while (scanner.hasNextInt()) {
            int selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu) {
                case 0:
                    return;
                case 1:
                    registration(scanner);
                    break;
                case 2:
                    importCitizens(scanner);
                    break;
                case 3:
                    generate(scanner);
                    break;
                case 4:
                    vaccination(scanner);
                    break;
                case 5:
                    failedVaccination(scanner);
                    break;
                case 6:
                    generateVaccinationReport(scanner);
                    break;
            }
            mainMenu();
        }
    }

    public void mainMenu() {
        System.out.println("1. Regisztráció");
        System.out.println("2. Tömeges regisztráció");
        System.out.println("3. Generálás");
        System.out.println("4. Oltás");
        System.out.println("5. Oltás meghiúsulás");
        System.out.println("6. Riport");
        System.out.println("0. Kilépés");
    }

    private void registration(Scanner scanner) {
        Citizen citizen = userInputHandler.getCitizenForRegistration(scanner, dao);
        dao.setCitizen(citizen);
    }


    private void generate(Scanner scanner) {
        String zip = userInputHandler.getZip(scanner, dao);
        String path = userInputHandler.getPath(scanner);
        fileHandler.generateVaccinatingReport(path, dao.getCitizensForReport(zip));
    }

    private void importCitizens(Scanner scanner) {
        String path = userInputHandler.getPath(scanner);
        List<Citizen> citizens = fileHandler.getCitizensFromCsv(path);
        dao.insertCitizens(citizens);
    }

    private void vaccination(Scanner scanner) {
        String taj = userInputHandler.getTAJ(scanner);

        Citizen citizen = dao.getCitizenWithTAJ(taj);

        if (citizen.getNumberOfVaccination() == 0) {
            vaccination1(scanner, citizen);
        } else if (citizen.getNumberOfVaccination() == 1) {
            vaccination2(scanner, citizen);
        } else {
            System.out.println("A kiválasztott személy már megkapta mindkét oltását!");
        }
    }

    private void vaccination2(Scanner scanner, Citizen citizen) {
        System.out.println("Az előző oltás időpontja: " + citizen.getLastVaccination() + " \nfajtája: " + citizen.getLastVaccinationType());

        citizen.setLastVaccination(userInputHandler.getVaccinationDateTime(scanner));
        citizen.setNumberOfVaccination(citizen.getNumberOfVaccination() + 1);

        dao.setCitizenVaccination(citizen, "none", "OK", citizen.getLastVaccinationType());
    }

    private void vaccination1(Scanner scanner, Citizen citizen) {
        citizen.setLastVaccination(userInputHandler.getVaccinationDateTime(scanner));
        String vaccineType = userInputHandler.getVaccinationType(scanner);

        citizen.setNumberOfVaccination(citizen.getNumberOfVaccination() + 1);

        dao.setCitizenVaccination(citizen, "none", "OK", vaccineType);
    }

    private void failedVaccination(Scanner scanner) {
        String taj = userInputHandler.getTAJ(scanner);

        Citizen citizen = dao.getCitizenWithTAJ(taj);
        String note = userInputHandler.getVaccinationFailNote(scanner);
        dao.setCitizenVaccination(citizen, note, "NOT OK", citizen.getLastVaccinationType());
    }

    private void generateVaccinationReport(Scanner scanner) {
        String path = userInputHandler.getPath(scanner);
        fileHandler.generateVaccinatedReport(path, dao.getVaccinatedCitizens());
    }

}

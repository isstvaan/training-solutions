package covid;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class UserInputHandler {

    public Citizen getCitizenForRegistration(Scanner scanner, CovidDao dao) {
        Citizen citizen = new Citizen();

        citizen.setName(getName(scanner));

        citizen.setZip(getZip(scanner, dao));

        citizen.setAge(getAge(scanner));

        citizen.setEmail(getEmail(scanner));

        confirmEmail(scanner, citizen);

        citizen.setTaj(getTAJ(scanner));

        return citizen;
    }

    public String getPath(Scanner scanner) {
        System.out.println("Kérem adja meg az elérési utat:");
        String path = scanner.nextLine();
        while (!Validator.isValidPath(path)) {
            System.out.println("Érvénytelen útonal! Adja meg újra");
            path = scanner.nextLine();
        }
        return path;
    }

    public String getTAJ(Scanner scanner) {
        System.out.println("Kérem adja meg a TAJ számot:");
        String taj = scanner.nextLine();
        while (!Validator.isValidTAJ(taj)) {
            System.out.println("Érvénytelen TAJ, kérem adja meg újra.");
            taj = scanner.nextLine();
        }
        return taj;
    }

    private void confirmEmail(Scanner scanner, Citizen citizen) {
        System.out.println("Kérem erősítse meg az email címet:");
        while (!citizen.getEmail().equals(scanner.nextLine())) {
            System.out.println("Érvénytelen email cím, a két adat nem egyezik.");
        }
    }

    private String getEmail(Scanner scanner) {
        System.out.println("Kérem adja meg az email címet:");
        String email = scanner.nextLine();
        while (!Validator.isValidEmailAddress(email)) {
            System.out.println("Érvénytelen email cím, kérem adja meg újra.");
            email = scanner.nextLine();
        }
        return email;
    }

    private int getAge(Scanner scanner) {
        System.out.println("Kérem adja meg az életkort:");
        int age = scanner.nextInt();
        while (!Validator.isValidAge(age)) {
            scanner.nextLine();
            System.out.println("Érvénytelen életkor, kérem adja meg újra.");
            age = scanner.nextInt();
        }
        scanner.nextLine();
        return age;
    }

    private String getName(Scanner scanner) {
        System.out.println("Irja be a nevet:");
        String name = scanner.nextLine();
        while (!Validator.isValidString(name)) {
            System.out.println("Érvénytelen név, kérem adja meg újra.");
            name = scanner.nextLine();
        }
        return name;
    }

    public String getZip(Scanner scanner, CovidDao dao) {
        System.out.println("Kérem adja meg az irányítószámot:");
        String zip = scanner.nextLine();
        while (!Validator.isValidString(zip) || dao.getCityForZip(zip) == null) {
            System.out.println("Érvénytelen irányítószám, kérem adja meg újra.");
            zip = scanner.nextLine();
        }
        System.out.println("Irányítószámhoz tartozó település: " + dao.getCityForZip(zip));
        return zip;
    }

    public LocalDateTime getVaccinationDateTime(Scanner scanner) {
        while (true) {
            System.out.println("Kérem adja meg az oltás dátumát (pl:2021.10.10 12:30):");
            try {
                return LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm", new Locale("hu-HU")));
            } catch (DateTimeParseException ex) {
                System.out.println("Érvénytelen dátum!");
            }
        }
    }

    public String getVaccinationType(Scanner scanner) {
        System.out.println("Kérem adja meg az oltás fajtáját:");
        String vaccineType = scanner.nextLine();
        return vaccineType;
    }

    public String getVaccinationFailNote(Scanner scanner) {
        System.out.println("Kérem adja meg hogy miért hiusult meg az oltás:");
        String note = scanner.nextLine();
        return note;
    }
}

package covid;

import java.io.File;
import java.io.IOException;

public class Validator {

    public static boolean isValidString(String str) {
        return str != null && !str.isBlank();
    }

    public static boolean isValidAge(int age) {
        return age > 10 && age < 150;
    }

    public static boolean isValidPath(String path) {
        File f = new File(path);
        try {
            f.getCanonicalPath();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isValidEmailAddress(String email) {
        return email != null &&
                email.length() >= 3 &&
                email.contains("@") &&
                email.contains(".");
    }

    public static boolean isValidTAJ(String taj) {
        if (taj.length() != 9) {
            return false;
        }
        int calculatedValue = 0;
        for (int i = 0; i < taj.length() - 1; i++) {
            int tmp = Integer.parseInt(String.valueOf(taj.charAt(i)));
            if ((i + 1) % 2 == 0) {
                calculatedValue += (tmp * 7);
            } else {
                calculatedValue += (tmp * 3);
            }
        }

        calculatedValue = calculatedValue % 10;
        return calculatedValue == Integer.parseInt(String.valueOf(taj.charAt(taj.length() - 1)));
    }
}

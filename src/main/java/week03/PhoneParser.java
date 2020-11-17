package week03;

import java.util.Scanner;

public class PhoneParser {
    public Phone parsePhone(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number can't be null.");
        }

        String[] tmp = phoneNumber.split("\\+");
        if (tmp.length < 2) {
            throw new IllegalArgumentException("Not valid phone number.");
        }
        return new Phone(tmp[0], tmp[1]);
    }
}

public class SsnValidator {

    public boolean validate(String socialSecurityNumber) {
        if (socialSecurityNumber.length() < 9) {
            return false;
        }

        try {

            int sumValue = 0;
            for (int i = 0; i < socialSecurityNumber.length() - 2; i++) {
                int value = Integer.parseInt(Character.toString((socialSecurityNumber.charAt(i))));
                sumValue += (i % 2 == 0 ? value * 7 : value * 3);
            }

            int validatorValue = Integer.parseInt(Character.toString((socialSecurityNumber.charAt(socialSecurityNumber.length() - 1))));
            return validatorValue == sumValue % 10;

        } catch (Exception ex) {
            return false;
        }
    }
}

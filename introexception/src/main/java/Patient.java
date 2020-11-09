public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name parameter is not valid!");
        }

        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("yearOfBirth parameter is not valid!");
        }

        if (!new SsnValidator().validate(socialSecurityNumber)) {
            throw new IllegalArgumentException("socialSecurityNumber parameter is not valid!");
        }

        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

}

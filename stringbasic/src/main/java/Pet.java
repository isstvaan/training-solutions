public class Pet {
    public enum Gender {
        MALE,
        FEMALE,
        UNKNOWN
    }

    private String name;    //String
    private int yearOfBirth;    //int, vagy LocalDate
    private Gender gender;  //ENUM
    private String regNumber;  //int, ha akarunk vele aritmetikai műveleteket csinálni, különben String

    public Pet(String name, int yearOfBirth, Gender gender, String regNumber) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegNumber() {
        return regNumber;
    }
}

package covid;

import java.time.LocalDateTime;

public class Citizen {
    private long id;
    private String name;
    private String zip;
    private int age;
    private String email;
    private String taj;
    private int numberOfVaccination;
    private LocalDateTime lastVaccination;


    private String lastVaccinationType;

    public Citizen() {
    }

    public Citizen(long id, String name, String zip, int age, String email, String taj, int numberOfVaccination, LocalDateTime lastVaccination, String lastVaccinationType) {
        this.id = id;
        this.name = name;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.taj = taj;
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccination = lastVaccination;
        this.lastVaccinationType = lastVaccinationType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    public String getLastVaccinationType() {
        return lastVaccinationType;
    }

    public void setLastVaccinationType(String lastVaccinationType) {
        this.lastVaccinationType = lastVaccinationType;
    }

    public void setNumberOfVaccination(int numberOfVaccination) {
        this.numberOfVaccination = numberOfVaccination;
    }

    public void setLastVaccination(LocalDateTime lastVaccination) {
        this.lastVaccination = lastVaccination;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDateTime getLastVaccination() {
        return lastVaccination;
    }

    public static Citizen fromCsvFormat(String str) {
        String[] splittedStr = str.split(";");

        if (!Validator.isValidString(str) ||
                !Validator.isValidString(splittedStr[0]) ||
                !Validator.isValidString(splittedStr[1]) ||
                !Validator.isValidString(splittedStr[2]) ||
                !Validator.isValidAge(Integer.parseInt(splittedStr[2])) ||
                !Validator.isValidEmailAddress(splittedStr[3])// ||
            // !Validator.isValidTAJ(splittedStr[4])
        ) {
            throw new IllegalArgumentException("Érvényten csv adat:" + str);
        }

        Citizen citizen = new Citizen();
        citizen.setName(splittedStr[0]);
        citizen.setZip(splittedStr[1]);
        citizen.setAge(Integer.parseInt(splittedStr[2]));
        citizen.setEmail(splittedStr[3]);
        citizen.setTaj(splittedStr[4]);


        return citizen;
    }

}

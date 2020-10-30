import java.time.LocalDate;

public class Employee {
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate beginEmployement;

    public Employee(int year, int month, int day, String name) {
        beginEmployement = LocalDate.now();
        dateOfBirth = LocalDate.of(year, month, day);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getBeginEmployement() {
        return beginEmployement;
    }
}

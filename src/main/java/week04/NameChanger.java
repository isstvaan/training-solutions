package week04;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if (isEmpty(fullName)) {
            throw new IllegalArgumentException("Name can't be empty.");
        }

        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void changeFirstName(String firstName) {
        String[] tmp = fullName.split(" ");
        fullName = firstName + " " + tmp[1];
    }

    private boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }
}

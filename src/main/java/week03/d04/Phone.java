package week03.d04;

public class Phone {
    private String prefix;
    private String number;

    public Phone(String prefix, String number) {

        if (prefix == null || prefix.isBlank() || number == null || number.isBlank()) {
            throw new IllegalArgumentException("Not valid parameters.");
        }

        this.prefix = prefix;
        this.number = number;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone: " + prefix + "/" + number;
    }
}

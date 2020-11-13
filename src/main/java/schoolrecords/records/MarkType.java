package schoolrecords.records;

public enum MarkType {
    A(5, "excellent"),
    B(4, "very good"),
    C(3, "improvement needed"),
    D(2, "close fail"),
    F(1, "fail");

    private int value;
    private String description;

    MarkType(int value, String description) {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Value parameter is not valid.");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description parameter must not be empty!");
        }
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}

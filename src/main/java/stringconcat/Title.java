package stringconcat;

public enum Title {
    MR("Mr."), MRS("Mrs."), MS("Ms."), DR("Dr."), NONE("");

    private String stringValue;

    Title(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}

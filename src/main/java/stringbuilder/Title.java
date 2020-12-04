package stringbuilder;

public enum Title {
    MR("Mr."), MRS("Mrs."), MS("Ms."), DR("Dr."), PROF("Prof."), NONE("");

    private String stringValue;

    Title(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}

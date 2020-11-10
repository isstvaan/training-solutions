package enumtype.unit;

public enum LengthUnit {
    MM(true, 1),
    CM(true, 10),
    M(true, 1000),
    YARD(false, 914),
    FOOT(false, 304),
    INCH(false, 25);

    private boolean isSI;
    private int valueInMillimeter;

    LengthUnit(boolean si, int millimeterValue) {
        isSI = si;
        valueInMillimeter = millimeterValue;
    }

    public boolean isSI() {
        return isSI;
    }

    public void setSI(boolean SI) {
        isSI = SI;
    }

    public int getValueInMillimeter() {
        return valueInMillimeter;
    }

    public void setValueInMillimeter(int valueInMillimeter) {
        this.valueInMillimeter = valueInMillimeter;
    }
}

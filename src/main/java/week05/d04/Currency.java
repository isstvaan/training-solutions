package week05.d04;

public enum Currency {
    HUF(1), USD(300);

    private int convertFactor;

    Currency(int convertFactor) {
        this.convertFactor = convertFactor;
    }

    public int getConvertFactor() {
        return convertFactor;
    }
}

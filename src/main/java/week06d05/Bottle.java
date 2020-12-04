package week06d05;

public class Bottle {
    private BottleType type;
    private int filledUntil;

    public Bottle(BottleType type) {
        if (type == null) {
            throw new IllegalArgumentException("Type can't be null");
        }
        this.type = type;
    }

    public void fill(int fillAmount) {
        if (filledUntil + fillAmount > type.getMaximumAmount()) {
            throw new IllegalStateException("Bottle overfilled.");
        }
        filledUntil += fillAmount;
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }

    public static Bottle of(BottleType type) {
        return new Bottle(type);
    }
}

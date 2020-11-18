package constructoroverloading.bus;

public class SimpleTime {
    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this(hours, 0);
    }

    public SimpleTime(SimpleTime time) {
        this(time.getHours(), time.getMinutes());
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int difference(SimpleTime time) {
        return (60 * hours) + minutes - (60 * time.getHours()) - time.getMinutes();
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }
}

package methodoverloading.time;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    public Time(int hours) {
        this(hours, 0, 0);
    }

    public Time(Time time) {
        this(time.getHours(), time.getMinutes(), time.getSeconds());
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isEqual(Time time) {
        return isEqual(time.getHours(), time.getMinutes(), time.getSeconds());
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return (3600 * this.hours) + (60 * this.minutes) + this.seconds ==
                (3600 * hours) + (60 * minutes) + seconds;
    }

    public boolean isEarlier(Time time) {
        return isEarlier(time.getHours(), time.getMinutes(), time.getSeconds());
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        return (3600 * this.hours) + (60 * this.minutes) + this.seconds <
                (3600 * hours) + (60 * minutes) + seconds;
    }
}

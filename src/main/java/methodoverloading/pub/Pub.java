package methodoverloading.pub;

import methodoverloading.time.Time;

public class Pub {
    private String name;
    private Time time;

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.time = new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return time;
    }

    @Override
    public String toString() {
        return name + ";" + time.getHours() + ":" + time.getMinutes();

    }
}

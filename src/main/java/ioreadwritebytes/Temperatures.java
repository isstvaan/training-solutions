package ioreadwritebytes;

import java.util.List;

public class Temperatures {
    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public double getYearAverage() {
        if (data.length == 0) {
            return 0;
        }

        double sum = 0;
        for (byte item : data) {
            sum += item;
        }
        return sum / data.length;
    }

    public double getMonthAverage() {
        if (data.length == 0) {
            return 0;
        }

        double sum = 0;
        int counter = 0;
        for (int i = data.length - 1; i >= 0 && i >= data.length - 30; i--) {
            sum += data[i];
            counter++;
        }
        return sum / counter;
    }

    public byte[] getData() {
        return data;
    }
}

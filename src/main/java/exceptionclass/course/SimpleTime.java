package exceptionclass.course;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SimpleTime {
    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String timeStr) {
        if (timeStr == null) {
            throw new InvalidTimeException("Time is null");
        }
        String[] hourMinute = timeStr.split(":");

        if (hourMinute.length < 2) {
            throw new InvalidTimeException("Time is not hh:mm");
        }

        int hour = 0;
        int minute = 0;
        try {
            hour = Integer.parseInt(hourMinute[0]);
        } catch (NumberFormatException ex) {
            throw new InvalidTimeException("Time is not hh:mm");
        }

        try {
            minute = Integer.parseInt(hourMinute[1]);
        } catch (NumberFormatException ex) {
            throw new InvalidTimeException("Time is not hh:mm");
        }

        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("hh:mm"));
    }
}

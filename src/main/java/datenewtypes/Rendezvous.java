package datenewtypes;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime rendezvousTime;

    public Rendezvous(int hour, int minute) {
        rendezvousTime = LocalTime.of(hour, minute);
    }

    public Rendezvous(String timeStr, String formatStr) {
        validateFormatString(formatStr);

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);

            try {
                rendezvousTime = LocalTime.parse(timeStr, formatter);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException("Illegal time string: " + timeStr);
            }
        } catch (IllegalStateException ex) {
            throw new IllegalArgumentException("Illegal format string: " + formatStr);
        }
    }

    public void pushLater(int hour, int minute) {
        rendezvousTime = rendezvousTime.plusHours(hour).plusMinutes(minute);
    }

    public void pullEarlier(int hour, int minute) {
        rendezvousTime = rendezvousTime.minusHours(hour).minusMinutes(minute);
    }

    public int countMinutesLeft(LocalTime base) {
        int timeToGo = (int) ChronoUnit.MINUTES.between(base, rendezvousTime);
        if (timeToGo <= 0) {
            throw new MissedOpportunityException("Too late!");
        }
        return timeToGo;
    }

    public void validateFormatString(String formatStr) {
        if (formatStr == null || formatStr.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
    }

    public String toString(String formatStr) {
        validateFormatString(formatStr);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
        return formatter.format(rendezvousTime);
    }

}
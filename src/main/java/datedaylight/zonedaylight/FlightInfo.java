package datedaylight.zonedaylight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {
    private final ZonedDateTime zonedDateTime;

    public FlightInfo(String dateStr, String pattern, Locale locale, ZoneId zoneId) {
        if (isEmpty(dateStr)) {
            throw new IllegalArgumentException("Empty date string parameter!");
        }

        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string parameter!");
        }

        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }

        try {
            zonedDateTime = ZonedDateTime.of(LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern, locale)), zoneId);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Wrong date");
        }
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {
        return zonedDateTime.withZoneSameInstant(zone).plusHours(flightHours).plusMinutes(flightMinutes);
    }

    public ZonedDateTime getZonedDateTime()
    {
        return zonedDateTime;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}

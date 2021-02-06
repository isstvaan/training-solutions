package datedaylight.zonedaylight;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class WorkHoursCalculator {
    private final ZonedDateTime zonedDateTime;

    public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone) {
        zonedDateTime = ZonedDateTime.of(startYear, startMonth.getValue(), startDay, startHour, 0, 0, 0, zone);
    }

    public long calculateHours(int year, Month month, int day, int hour) {
        return Duration.between(zonedDateTime, ZonedDateTime.of(year, month.getValue(), day, hour, 0, 0, 0, zonedDateTime.getZone())).toHours();
    }

    public ZonedDateTime getStartDateTime() {
        return zonedDateTime;
    }
}

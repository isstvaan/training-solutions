package datenewtypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {
    private LocalDate dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public DateOfBirth(int year, Month month, int day) {
        this(year, month.getValue(), day);
    }

    public DateOfBirth(String dateStr, String formatStr, Locale locale) {
        if (!isValid(formatStr)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + formatStr);
        }

        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr, locale);
        getDateFromString(dateStr, formatter);
    }

    public DateOfBirth(String dateStr, String formatStr) {
        if (!isValid(formatStr)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + formatStr);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
        getDateFromString(dateStr, formatter);
    }

    public DateOfBirth(String dateStr) {

        this.dateOfBirth = LocalDate.parse(dateStr);
    }


    private void getDateFromString(String dateStr, DateTimeFormatter formatter) {
        if (!isValid(dateStr)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + dateStr);
        }
        if (formatter == null) {
            throw new IllegalArgumentException("Formatter can't be null.");
        }
        try {
            dateOfBirth = LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Illegal date string: " + dateStr);
        }
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate birthdayLater) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return birthdayLater.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }


    public int countDaysSinceBirth(LocalDate base) {
        if (base.isBefore(dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return (int) ChronoUnit.DAYS.between(dateOfBirth, base);
    }

    public int countDaysBetween(DateOfBirth other) {
        if (other == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
        return (int) ChronoUnit.DAYS.between(dateOfBirth, other.dateOfBirth);
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private boolean isValid(String str) {
        return str != null && !str.isBlank();
    }

    public String toString(String formatStr) {
        if (!isValid(formatStr)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + formatStr);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
        return formatter.format(dateOfBirth);
    }
}

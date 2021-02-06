package dateoldtypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateOfBirth {
    private Date dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day);
        dateOfBirth = calendar.getTime();
    }

    public DateOfBirth(String dateStr, String formatStr) {
        if (isEmpty(formatStr)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + formatStr);
        }
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        try {
            dateOfBirth = formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: " + dateStr, e);
        }
    }

    public DateOfBirth(String dateStr, String formatStr, Locale locale) throws ParseException {
        if (isEmpty(formatStr)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + formatStr);
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr, locale);
        try {
            dateOfBirth = formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: " + dateStr, e);
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    private boolean isValid(String str) {
        return str != null && !str.isBlank();
    }

    public String toString(String formatStr) {
        if (!isValid(formatStr)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + formatStr);
        }
        DateFormat formatter = new SimpleDateFormat(formatStr);
        return formatter.format(dateOfBirth);
    }

    public boolean isWeekDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateOfBirth);
        return calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY;
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateOfBirth);

        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
    }


}

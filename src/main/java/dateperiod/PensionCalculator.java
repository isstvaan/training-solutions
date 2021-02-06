package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PensionCalculator {
    private static final int DAYS_IN_MONTH = 30;
    public static final int DAYS_IN_YEAR = 365;
    private final List<Period> periodList = new ArrayList<>();

    public void addEmploymentPeriod(Period period) {
        periodList.add(period);
    }

    public Period sumEmploymentPeriods() {
        return periodList.stream().reduce(Period.ZERO, Period::plus, Period::plus).normalized();
    }

    public int calculateTotalDays(Period period) {
        return period.getYears() * DAYS_IN_YEAR + period.getMonths() * DAYS_IN_MONTH + period.getDays();
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: " + pattern);
        }
        if (isEmpty(fromDate)) {
            throw new IllegalArgumentException("Empty from date string, cannot use: " + fromDate);
        }
        if (isEmpty(toDate)) {
            throw new IllegalArgumentException("Empty to date string, cannot use: " + toDate);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return Period.between(LocalDate.parse(fromDate, formatter), LocalDate.parse(toDate, formatter));
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }
        return Period.between(fromDate, toDate);
    }

    public Period modifyByDays(Period period, int days) {
        if (period.getDays() + days < DAYS_IN_MONTH) {
            return period.plusDays(days).normalized();
        }
        return fullyNormalized(period.plusDays(days));
    }

    private Period fullyNormalized(Period period) {
        if (period.getDays() < DAYS_IN_MONTH) {
            return period.normalized();
        }
        int allDays = period.getDays();
        int months = allDays / DAYS_IN_MONTH;
        int days = allDays % DAYS_IN_MONTH;
        period = period.plusDays((long) days - allDays);
        period = period.plusMonths(months);

        return period.normalized();
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}

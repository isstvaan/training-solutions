package lambdaintro;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {
    private List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = Arrays.asList(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        for (LocalDate item : birthdays) {
            if (item.get(ChronoField.MONTH_OF_YEAR) == date.get(ChronoField.MONTH_OF_YEAR) &&
                    item.get(ChronoField.DAY_OF_MONTH) == date.get(ChronoField.DAY_OF_MONTH)) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int actualYear = date.get(ChronoField.YEAR);
        LocalDate base = LocalDate.of(date.get(ChronoField.YEAR), date.get(ChronoField.MONTH_OF_YEAR), date.get(ChronoField.DAY_OF_MONTH));

        int minDayForBirthday = Integer.MAX_VALUE;
        for (LocalDate birthday : birthdays) {
            LocalDate nextBirthday = birthday.withYear(actualYear);
            if (nextBirthday.isBefore(base)) {
                nextBirthday = birthday.withYear(actualYear + 1);
            }
            int diff = (int) ChronoUnit.DAYS.between(base, nextBirthday);
            if (minDayForBirthday > diff) {
                minDayForBirthday = diff;
            }
        }
        return minDayForBirthday;
    }
}

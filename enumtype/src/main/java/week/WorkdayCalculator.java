package week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> dayTypes = new ArrayList<>();
        dayTypes.add(firstDay.getDayType());

        Day[] days = Day.values();
        Day nextDay = nextDay(firstDay);
        for (int i = 0; i < numberOfDays - 1; i++) {
            dayTypes.add(nextDay.getDayType());
            nextDay = nextDay(nextDay);
        }

        return dayTypes;
    }

    private Day nextDay(Day day) {
        if (day.ordinal() < Day.values().length - 1) {
            return Day.values()[day.ordinal() + 1];
        } else {
            return Day.MONDAY;
        }
    }
}

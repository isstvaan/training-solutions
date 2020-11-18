package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {
    private List<SimpleTime> simpleTimeList;

    public BusTimeTable(List<SimpleTime> timeTable) {
        simpleTimeList = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        simpleTimeList = new ArrayList<>();

        for (int i = firstHour; i <= lastHour; i++) {
            simpleTimeList.add(new SimpleTime(i, everyMinute));
        }

    }

    public List<SimpleTime> getTimeTable() {
        return simpleTimeList;
    }

    public SimpleTime nextBus(SimpleTime actual) {
        for (SimpleTime item : simpleTimeList) {
            if (item.difference(actual) > 0) {
                return item;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }

    public SimpleTime firstbus() {
        SimpleTime simpleTime = simpleTimeList.get(0);
        for (SimpleTime item : simpleTimeList) {
            if (simpleTime.difference(item) > 0) {
                simpleTime = item;
            }
        }
        return simpleTime;
    }
}

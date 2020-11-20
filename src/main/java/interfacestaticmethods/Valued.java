package interfacestaticmethods;

import java.util.List;

public interface Valued {
    double getValue();

    static double totalValue(List<Valued> valuedList) {
        double sumValue = 0;
        for (Valued item : valuedList) {
            sumValue += item.getValue();
        }
        return sumValue;
    }
}

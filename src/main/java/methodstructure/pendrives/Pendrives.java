package methodstructure.pendrives;

import java.util.List;

public class Pendrives {
    public Pendrive best(List<Pendrive> pendrives) {
        if (pendrives == null || pendrives.size() == 0) {
            throw new IllegalArgumentException("List can't be empty.");
        }

        if (pendrives.size() < 2) {
            return pendrives.get(0);
        }

        Pendrive pendrive = pendrives.get(0);
        for (int i = 1; i < pendrives.size(); i++) {
            int compareResult = pendrive.comparePricePerCapacity(pendrives.get(i));
            if (compareResult > 0) {
                pendrive = pendrives.get(i);
                i = 0;
            }
        }

        return pendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        if (pendrives == null || pendrives.size() == 0) {
            throw new IllegalArgumentException("List can't be empty.");
        }

        if (pendrives.size() < 2) {
            return pendrives.get(0);
        }

        Pendrive pendrive = pendrives.get(0);
        for (int i = 1; i < pendrives.size(); i++) {
            if (pendrive.cheaperThan(pendrives.get(i))) {
                pendrive = pendrives.get(i);
                i = 0;
            }
        }

        return pendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive item : pendrives) {
            if (item.getCapacity() == capacity) {
                item.risePrice(percent);
            }
        }
    }
}

package methodstructure.pendrives;

import java.util.List;

public class Pendrives {
    public Pendrive best(List<Pendrive> pendrives) {
        if (isEmpty(pendrives)) {
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
            }
        }

        return pendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        if (isEmpty(pendrives)) {
            throw new IllegalArgumentException("List can't be empty.");
        }

        if (pendrives.size() < 2) {
            return pendrives.get(0);
        }

        Pendrive pendrive = pendrives.get(0);
        for (int i = 1; i < pendrives.size(); i++) {
            if (pendrives.get(i).cheaperThan(pendrive)) {
                pendrive = pendrives.get(i);
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

    private boolean isEmpty(List<Pendrive> pendrives) {
        return pendrives == null || pendrives.isEmpty();
    }
}

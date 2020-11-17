package methodpass.troopers;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (isEmpty(trooper)) {
            throw new IllegalArgumentException("BB");
        }
        this.troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        if (isEmpty(name) || isEmpty(target)) {
            throw new IllegalArgumentException("BB");
        }
        Trooper trooper = findTrooperByName(name);
        if (trooper != null) {
            moveTrooper(trooper, target);
        }
    }

    public void moveClosestTrooper(Position target) {
        if (isEmpty(target)) {
            throw new IllegalArgumentException("BB");
        }

        Trooper trooper = findClosestTrooper(target);
        if (trooper != null) {
            moveTrooper(trooper, target);
        }
    }

    private Trooper findTrooperByName(String name) {
        for (Trooper item : troopers) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }


    private Trooper findClosestTrooper(Position target) {
        Trooper closestTrooprer = null;
        for (Trooper item : troopers) {
            if (closestTrooprer == null || item.distanceFrom(target) < closestTrooprer.distanceFrom(target)) {
                closestTrooprer = item;
            }
        }
        return closestTrooprer;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }

    private boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    private boolean isEmpty(Trooper trooper) {
        return trooper == null;
    }

    private boolean isEmpty(Position position) {
        return position == null;
    }
}

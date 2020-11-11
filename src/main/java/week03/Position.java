package week03;

import java.util.Arrays;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Position name='" + name + '\'' + ", bonus=" + bonus;
    }

    public static void main(String[] args) {
        List<Position> positions = Arrays.asList(new Position("Position1", 50000), new Position("Position2", 100_000), new Position("Position3", 200_000));
        for (Position position : positions) {
            if (position.bonus > 150_000) {
                System.out.println(position);
            }
        }
    }
}


package week08d01;

public class Sultan {
    private static final int CELL_COUNT = 100;

    public boolean[] openDoors() {
        boolean[] doors = new boolean[CELL_COUNT];

        for (int i = 0; i < doors.length; i++) {
            for (int j = 1; j <= 100; j++) {
                if ((i + 1) % j == 0) {
                    doors[i] = !doors[i];
                }
            }
        }

        return doors;
    }
}

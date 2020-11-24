package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public void loadShip(int peoples, int cargoWeight) {
        int remainingPersons = peoples;
        int remainingCargo = cargoWeight;

        for (Ship ship : ships) {
            if (ship instanceof CanCarryPassengers) {
                if (remainingPersons != 0) {
                    remainingPersons = ((CanCarryPassengers) ship).loadPassenger(remainingPersons);
                }
            }
            if (ship instanceof CanCarryGoods) {
                if (remainingCargo != 0) {
                    remainingCargo = ((CanCarryGoods) ship).loadCargo(remainingCargo);
                }
            }
        }

        waitingPersons = remainingPersons;
        waitingCargo = remainingCargo;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}

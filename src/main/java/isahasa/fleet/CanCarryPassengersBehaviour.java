package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers {
    private int passengers;
    private int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.passengers = 0;
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        if (this.passengers + passengers < maxPassengers) {
            this.passengers += passengers;
            return 0;
        } else {
            this.passengers = maxPassengers;
            return passengers - maxPassengers;
        }
    }

    @Override
    public int getPassengers() {
        return passengers;
    }
}

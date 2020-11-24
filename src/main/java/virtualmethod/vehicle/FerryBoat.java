package virtualmethod.vehicle;

public class FerryBoat extends Vehicle {
    private static int MAX_CARRY_WEIGHT = 2000;
    private Car car;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + PERSON_AVERAGE_WEIGHT + (car != null ? car.getVehicleWeight() : 0);
    }

    public boolean canCarry(Car car) {
        if (car == null) {
            return false;
        }

        return car.getVehicleWeight() < MAX_CARRY_WEIGHT;
    }

    public boolean load(Car car) {
        if (canCarry(car)) {
            this.car = car;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FerryBoat{car=" + car + '}';
    }
}

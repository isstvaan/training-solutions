package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryGoods, CanCarryPassengers {
    private CanCarryGoods canCarryGoods;
    private CanCarryPassengers canCarryPassengers;

    public FerryBoat(int maxCarry,int maxPassengers) {
        this.canCarryGoods = new CanCarryGoodsBehaviour(maxCarry);
        this.canCarryPassengers =new CanCarryPassengersBehaviour(maxPassengers);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return canCarryGoods.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return canCarryGoods.getCargoWeight();
    }

    @Override
    public int loadPassenger(int passengers) {
        return canCarryPassengers.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return canCarryPassengers.getPassengers();
    }
}

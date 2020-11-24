package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods {
	private int cargoWeight;
	private int maxCargoWeight;

	public CanCarryGoodsBehaviour(int maxCargoWeight) {
		this.cargoWeight = 0;
		this.maxCargoWeight = maxCargoWeight;
	}

	@Override
	public int loadCargo(int cargoWeight) {
		if (this.cargoWeight + cargoWeight < maxCargoWeight) {
			this.cargoWeight += cargoWeight;
			return 0;
		} else {
			this.cargoWeight = maxCargoWeight;
			return cargoWeight - maxCargoWeight;
		}
	}

	@Override
	public int getCargoWeight() {
		return cargoWeight;
	}
}

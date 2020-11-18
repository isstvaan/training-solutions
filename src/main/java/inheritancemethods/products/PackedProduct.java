package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PackedProduct extends Product {
    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeigth, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeigth, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        int boxesCount = pieces / packingUnit;
        boxesCount += pieces % packingUnit > 0 ? 1 : 0;
        return super.totalWeight(pieces).add(weightOfBox.multiply(new BigDecimal(boxesCount))).setScale(super.getNumberOfDecimals(), RoundingMode.HALF_UP);
    }
}

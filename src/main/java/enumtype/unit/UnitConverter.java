package enumtype.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {
    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
        return length.multiply(new BigDecimal(source.getValueInMillimeter()))
                .divide(new BigDecimal(target.getValueInMillimeter()), 4, RoundingMode.HALF_UP);
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> siUnits = new ArrayList<>();
        for (LengthUnit unit :
                LengthUnit.values()) {
            if (unit.isSI()) {
                siUnits.add(unit);
            }
        }
        return siUnits;
    }
}

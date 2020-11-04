package unit;

import java.math.BigDecimal;

public class UnitConverterMain {
    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();

        System.out.println("100 MM -> CM:" + unitConverter.convert(new BigDecimal(100), LengthUnit.MM, LengthUnit.CM));
        System.out.println("100 MM -> M:" + unitConverter.convert(new BigDecimal(100), LengthUnit.MM, LengthUnit.M));
        System.out.println("100 MM -> YARD:" + unitConverter.convert(new BigDecimal(100), LengthUnit.MM, LengthUnit.YARD));
        System.out.println("100 MM -> FOOT:" + unitConverter.convert(new BigDecimal(100), LengthUnit.MM, LengthUnit.FOOT));
        System.out.println("100 MM -> INCH:" + unitConverter.convert(new BigDecimal(100), LengthUnit.MM, LengthUnit.INCH));

        System.out.println("Units:");
        for (LengthUnit unit :
                LengthUnit.values()) {
            System.out.println(unit.name());
        }

        System.out.println("Si units:");
        for (LengthUnit unit :
                unitConverter.siUnits()) {
            System.out.println(unit.name());
        }

        //BONUSZ:
        //Válasz a nextDay() valamint a siUnits() nem jó helyen vannak, az enumokban lenne a helyük, Én még statikussá is tenném őket
    }
}

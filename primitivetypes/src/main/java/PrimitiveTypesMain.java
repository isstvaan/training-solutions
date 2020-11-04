public class PrimitiveTypesMain {
    public static void main(String[] args) {
        PrimitiveTypes primitiveTypes = new PrimitiveTypes();
        System.out.println(primitiveTypes.toBinaryString(583));
        System.out.println(Integer.toString(583, 2));

        String filledBinValue = primitiveTypes.toBinaryString(583);
        System.out.println(filledBinValue);

        System.out.println(primitiveTypes.toBinaryString(-67));
        System.out.println(Integer.toString(-67, 2));


        System.out.println(new Integer(1) + new Integer(2));

        int minusNumber = 0b11111111111111111111111110111101;
        System.out.println(minusNumber);

    }
}

package typeconversion.dataloss;

public class DataLoss {

    public void dataLoss() {
        long number = 0;
        int counter = 0;

        for (int i = 0; i < 3; ) {
            float convertedNumberFloat = (float) number;
            long convertedNumberLong = (long) convertedNumberFloat;

            if (convertedNumberLong != number) {
                System.out.println("Dataloss:");
                System.out.println("Number: " + number);
                System.out.println("Converted number: " + convertedNumberLong);
                System.out.println("Number binary: " + Long.toString(number, 2));
                System.out.println("Converted number binary: " + Long.toString(convertedNumberLong, 2));
                System.out.println("Difference: " + (number - convertedNumberLong));
                i++;
            }
            number++;
        }
    }

    public static void main(String[] args) {
        new DataLoss().dataLoss();
    }
}

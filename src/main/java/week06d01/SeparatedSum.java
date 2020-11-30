package week06d01;

public class SeparatedSum {

    public PositiveNegativeNumbers sum(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("String can't be empty.");
        }

        String[] splittedStr = str.split(";");

        double sumPositive = 0;
        double sumNegative = 0;
        for (String item : splittedStr) {

            double tmp = Double.parseDouble(item.replace(',', '.'));
            if (tmp > 0) {
                sumPositive += tmp;
            } else if (tmp < 0) {
                sumNegative += tmp;
            }
        }

        return new PositiveNegativeNumbers(sumPositive, sumNegative);
    }

    public static void main(String[] args) {
        System.out.println(new SeparatedSum().sum("1,1;3,9;-1.9;-3.1;0"));
    }
}

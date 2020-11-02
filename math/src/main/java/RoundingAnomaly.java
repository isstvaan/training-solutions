import java.util.Random;

public class RoundingAnomaly {

    public double[] randomNumbers(int size, double max, int scale) {
        Random random = new Random();
        double[] retVal = new double[size];

        for (int i = 0; i < size; i++) {
            retVal[i] = random.nextDouble() * max * Math.pow(10, scale);
        }
        return retVal;
    }

    private double roundAfterSum(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return Math.round(sum);
    }

    private double sumAfterRound(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Math.round(numbers[i]);
        }

        return sum;
    }

    public double difference(int size, double max, int scale) {
        double[] numbers = randomNumbers(size, max, scale);
        double afterSumResult = roundAfterSum(numbers);
        double afterRoundResult = sumAfterRound(numbers);
        return Math.abs(afterSumResult - afterRoundResult);
    }

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();

        double sumDifference = 0;
        for (int i = 0; i < 100; i++) {
            sumDifference += roundingAnomaly.difference(1000, 1000000, 10);
            System.out.println(sumDifference);
        }

    }
}

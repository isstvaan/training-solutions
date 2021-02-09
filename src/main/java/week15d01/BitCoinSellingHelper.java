package week15d01;

import java.util.List;

public class BitCoinSellingHelper {


    public BestRate getBestBitvoinRate(List<Integer> rates) {
        BestRate bestRate = new BestRate(0, 0);
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < rates.size(); i++) {
            for (int j = i; j < rates.size() - 1; j++) {
                int currentDiff = rates.get(j) - rates.get(i);
                if (currentDiff > maxDiff) {
                    bestRate = new BestRate(i + 1, j + 1);
                    maxDiff = currentDiff;
                }
            }
        }
        return bestRate;
    }

    public static void main(String[] args) {
        System.out.println(new BitCoinSellingHelper().getBestBitvoinRate(List.of(100, 120, 40, 70, 200, 30, 50)));
    }
}

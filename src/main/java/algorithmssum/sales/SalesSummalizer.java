package algorithmssum.sales;

import java.util.List;

public class SalesSummalizer {
    public int getSalesSum(List<Salesperson> persons) {
        int sum = 0;
        for (Salesperson person : persons) {
            sum += person.getAmount();
        }
        return sum;
    }
}

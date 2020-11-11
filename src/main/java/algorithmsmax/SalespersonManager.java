package algorithmsmax;

import java.util.List;

public class SalespersonManager {

    public int getMaxAmount(List<Salesperson> salespersonList) {
        int maxValue = Integer.MIN_VALUE;
        for (Salesperson saleperson : salespersonList) {
            maxValue = maxValue < saleperson.getAmount() ? saleperson.getAmount() : maxValue;
        }
        return maxValue;
    }

    public Salesperson getMaxOverTheTarget(List<Salesperson> salespersonList) {
        Salesperson maxSalesperson = null;
        for (Salesperson saleperson : salespersonList) {
            maxSalesperson = maxSalesperson == null ? saleperson :
                    maxSalesperson.getAmount() - maxSalesperson.getTarget() < saleperson.getAmount() - saleperson.getTarget() ? saleperson : maxSalesperson;
        }
        return maxSalesperson;
    }

    public Salesperson getMaxBelowTheTarget(List<Salesperson> salespersonList) {
        Salesperson minSalesperson = null;
        for (Salesperson saleperson : salespersonList) {
            minSalesperson = minSalesperson == null ? saleperson :
                    minSalesperson.getAmount() - minSalesperson.getTarget() > saleperson.getAmount() - saleperson.getTarget() ? saleperson : minSalesperson;
        }
        return minSalesperson;
    }

}

package lambdaprimitives;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SportGadgetStore {
    private final List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public long getNumberOfProducts() {
        return products.stream().mapToInt(Product::getCount).sum();
    }

    public String getExpensiveProductStatistics(double value) {
        List<Product> tmp = products.stream().filter(o -> o.getPrice() > value).collect(Collectors.toList());
        if (tmp.size() > 0) {
            IntSummaryStatistics stat = tmp.stream().mapToInt(Product::getCount).summaryStatistics();
            return "Összesen " + stat.getCount() + " féle termék, amelyekből minimum " + stat.getMin() + " db, maximum " + stat.getMax() + " db, összesen " + stat.getSum() + " db van.";
        }
        return "Nincs ilyen termék.";

    }

    public double getAveragePrice() {
        return products.stream().mapToDouble(Product::getPrice).average().orElse(0);

    }
}

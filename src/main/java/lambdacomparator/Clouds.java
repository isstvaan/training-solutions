package lambdacomparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clouds {
    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        List<CloudStorage> retVal = new ArrayList<>(storages);
        retVal.sort(Comparator.comparing(CloudStorage::getProvider, String::compareToIgnoreCase));
        return retVal.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        List<CloudStorage> retVal = new ArrayList<>(storages);
        retVal.sort(Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.naturalOrder())).thenComparing(CloudStorage::getPrice));
        return retVal.get(0);
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        List<CloudStorage> retVal = new ArrayList<>(storages);

        retVal.sort(Comparator.reverseOrder());

        return retVal.subList(0, Math.min(retVal.size(), 3));
    }
}

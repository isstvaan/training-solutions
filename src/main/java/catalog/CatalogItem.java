package catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CatalogItem implements Feature {
    private final List<Feature> features;
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... feature) {
        this.features = List.of(feature);
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int fullLengthAtOneItem() {
        int length = 0;
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                length += ((AudioFeatures) item).getLength();
            }
        }
        return length;
    }

    public boolean hasAudioFeature() {
        for (Feature item : features) {
            if (item instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }

    public int numberOfPagesAtOneItem() {
        for (Feature item : features) {
            if (item instanceof PrintedFeatures) {
                return ((PrintedFeatures) item).getNumberOfPages();
            }
        }
        return 0;
    }

    public List<Feature> getFeatures() {
        return new ArrayList<>(features);
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogItem that = (CatalogItem) o;
        return price == that.price &&
                Objects.equals(features, that.features) &&
                Objects.equals(registrationNumber, that.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(features, price, registrationNumber);
    }

    @Override
    public List<String> getContributors() {
        List<String> items = new ArrayList<>();
        for (Feature item : features) {
            items.addAll(item.getContributors());
        }
        return items;
    }

    @Override
    public String getTitle() {
        return "";
    }


    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature item : features) {
            titles.add(item.getTitle());
        }
        return titles;
    }
}

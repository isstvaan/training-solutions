package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    public final List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem item) {
        if (!catalogItems.contains(item)) {
            catalogItems.add(item);
        }
    }

    public double averagePageNumberOver(int pageNumber) {
        if (pageNumber < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        double pagesCount = 0;
        double counter = 0;

        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature() && item.numberOfPagesAtOneItem() > pageNumber) {
                pagesCount += item.numberOfPagesAtOneItem();
                counter++;
            }
        }
        if (pagesCount == 0) {
            throw new IllegalArgumentException("No page");
        }

        return pagesCount / counter;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).getRegistrationNumber().equals(registrationNumber)) {
                catalogItems.remove(i);
                return;
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        if (searchCriteria == null || !(searchCriteria.hasTitle() || searchCriteria.hasContributor())) {
            throw new IllegalStateException("Invalid searchCriteria");
        }

        if (searchCriteria.hasContributor() && !searchCriteria.hasTitle()) {
            return findByContributor(searchCriteria.getContributor());
        }
        if (searchCriteria.hasTitle() && !searchCriteria.hasContributor()) {
            return findByTitle(searchCriteria.getTitle());
        }
        return findByContributorAndTitle(searchCriteria.getContributor(), searchCriteria.getTitle());
    }

    private List<CatalogItem> findByTitle(String title) {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            for (Feature feature : item.getFeatures()) {
                if (feature.getTitle().equals(title)) {
                    items.add(item);
                    break;
                }
            }
        }

        return items;
    }

    private List<CatalogItem> findByContributor(String contributor) {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.getContributors().contains(contributor)) {
                items.add(item);
            }
        }

        return items;
    }

    private List<CatalogItem> findByContributorAndTitle(String contributor, String title) {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.getContributors().contains(contributor) && item.getTitles().contains(title)) {
                items.add(item);
            }
        }

        return items;
    }

    public int getAllPageNumber() {
        int pages = 0;
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                pages += item.numberOfPagesAtOneItem();
            }
        }
        return pages;
    }

    public int getFullLength() {
        int fullLength = 0;
        for (CatalogItem item : getAudioLibraryItems()) {
            fullLength += item.fullLengthAtOneItem();
        }
        return fullLength;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasAudioFeature()) {
                items.add(item);
            }
        }
        return items;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> items = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            if (item.hasPrintedFeature()) {
                items.add(item);
            }
        }
        return items;
    }

}

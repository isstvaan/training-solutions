package week06d02;

public class StoredProduct {
    private ProductCategory category;
    private int counts;

    public StoredProduct(ProductCategory category, int counts) {
        if (category == null) {
            throw new IllegalArgumentException("Category can't be null");
        }
        this.category = category;
        this.counts = counts;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public int getCounts() {
        return counts;
    }

    public void incrementCounts() {
        this.counts++;
    }

    @Override
    public String toString() {
        return category + ": " + counts;
    }
}

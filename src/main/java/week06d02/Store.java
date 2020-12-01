package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Products can't be null");
        }
        this.products = products;
    }

    private StoredProduct getStoredProductByCategory(List<StoredProduct> products, ProductCategory productCategory) {
        for (StoredProduct item : products) {
            if (item.getCategory() == productCategory) {
                return item;
            }
        }

        return null;
    }

    public List<StoredProduct> getProductsByCategory() {
        List<StoredProduct> productsByCategories = new ArrayList<>();

        for (Product item : products) {
            StoredProduct foundedProductCategory = getStoredProductByCategory(productsByCategories, item.getCategory());
            if (foundedProductCategory == null) {
                productsByCategories.add(new StoredProduct(item.getCategory(), 1));
            } else {
                foundedProductCategory.incrementCounts();
            }
        }

        return productsByCategories;
    }
}

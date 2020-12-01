package week06d02;

public class Product {
    private String name;
    private ProductCategory category;
    private long price;

    public Product(String name, ProductCategory category, long price) {
        if (!isValidString(name)) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category can't be null");
        }
        if (price < 1) {
            throw new IllegalArgumentException("Price must be positive number");
        }
        this.name = name;
        this.category = category;
        this.price = price;
    }

    private boolean isValidString(String str) {
        return str != null && !str.isBlank();
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public long getPrice() {
        return price;
    }
}

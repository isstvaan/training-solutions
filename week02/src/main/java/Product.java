public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product product) {
        return name.equals(product.getName()) && Math.abs(code.length() - product.getCode().length()) <= 1;
    }

    public static void main(String[] args) {
        Product product1 = new Product("Kakaó", "123456");
        Product product2 = new Product("Tej", "123456");
        Product product3 = new Product("Kakaó", "1234567");

        System.out.println("product1==product2:" + product1.areTheyEqual(product2));
        System.out.println("product1==product3:" + product1.areTheyEqual(product3));
        System.out.println("product2==product3:" + product2.areTheyEqual(product3));
    }

}

package classstructureintegrate;

import java.util.Scanner;

public class Product {
    private String name;

    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void increasePrice(int amount) {
        price = price + amount;
    }

    public void decreasePrice(int amount) {
        price = price - amount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A termék neve:");
        String name = scanner.nextLine();

        System.out.println("A termék ára:");
        int price = scanner.nextInt();

        Product product = new Product(name, price);
        System.out.println(product.getName() + " " + product.getPrice());

        product.increasePrice(10);
        System.out.println(product.getName() + " " + product.getPrice());

        product.decreasePrice(20);
        System.out.println(product.getName() + " " + product.getPrice());
    }
}

package classstructureconstructors;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Product name?");
        String name = scanner.nextLine();

        System.out.println("Product price?");
        int price = scanner.nextInt();

        Product product = new Product(name, price);

        System.out.println("Product datas:\nName: " + product.getName() + "\nPrice: " + product.getPrice());

    }
}

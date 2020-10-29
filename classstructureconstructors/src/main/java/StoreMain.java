public class StoreMain {
    public static void main(String[] args) {
        Store store1 = new Store("Product1");
        Store store2 = new Store("Product2");

        System.out.println("Store 1:" + store1.getProduct() + "; Quantity:" + store1.getStock());

        store1.store(3);
        System.out.println("Store 1 added 3 item to store");
        System.out.println("Store 1:" + store1.getProduct() + "; Quantity:" + store1.getStock());

        store1.dispatch(2);
        System.out.println("Store 1 removed 2 item from store");

        System.out.println("Store 1:" + store1.getProduct() + "; Quantity:" + store1.getStock());


        System.out.println("Store 2:" + store2.getProduct() + "; Quantity:" + store2.getStock());

        store2.store(30);
        System.out.println("Store 2 added 30 item to store");
        System.out.println("Store 2:" + store2.getProduct() + "; Quantity:" + store2.getStock());

        store2.dispatch(21);
        System.out.println("Store 2 removed 21 item from store");

        System.out.println("Store 2:" + store2.getProduct() + "; Quantity:" + store2.getStock());

    }
}

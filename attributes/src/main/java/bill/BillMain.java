package bill;

public class BillMain {
    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("Sajt 1", 10, 1000));
        bill.addItem(new Item("Sajt 2", 20, 2000));
        bill.addItem(new Item("Sajt 3", 30, 3000));

        System.out.println(bill.calculateTotalPrice());
    }
}

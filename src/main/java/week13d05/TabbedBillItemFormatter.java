package week13d05;

public class TabbedBillItemFormatter implements BillItemFormatter {
    @Override
    public String getFormatedString(BillItem item) {
        return String.format("%-20s %13s %5s %6s", item.getName(), item.getUnitPrice(), item.getNumber(), item.getUnitPrice() * item.getNumber());
    }
}

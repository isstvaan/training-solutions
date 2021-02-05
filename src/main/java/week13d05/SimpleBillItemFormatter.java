package week13d05;

public class SimpleBillItemFormatter implements BillItemFormatter {
    @Override
    public String getFormatedString(BillItem item) {
        return String.format("%d %s, darabja %d Ft", item.getNumber(), item.getName(), item.getUnitPrice());
    }
}

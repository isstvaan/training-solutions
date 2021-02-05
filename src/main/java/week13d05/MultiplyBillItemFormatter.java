package week13d05;

public class MultiplyBillItemFormatter implements BillItemFormatter {

    @Override
    public String getFormatedString(BillItem item) {
        return String.format("%s %d * %d = %d", item.getName(), item.getNumber(), item.getUnitPrice(), item.getNumber() * item.getUnitPrice());
    }
}

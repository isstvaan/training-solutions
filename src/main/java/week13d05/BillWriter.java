package week13d05;

import java.util.List;
import java.util.function.Function;

public class BillWriter {
    public String writeBills2(List<BillItem> billItemList, Function<BillItem, String> formatter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (BillItem item : billItemList) {
            stringBuilder.append(formatter.apply(item)).append("\n");
        }
        return stringBuilder.toString();
    }

    public String writeBills(List<BillItem> billItemList, BillItemFormatter formatter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (BillItem item : billItemList) {
            stringBuilder.append(formatter.getFormatedString(item)).append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        BillWriter billWriter = new BillWriter();
        List<BillItem> bills = List.of(
                new BillItem("kenyér", 3, 10),
                new BillItem("tej", 5, 20));

        System.out.println(billWriter.writeBills(bills, new SimpleBillItemFormatter()));
        System.out.println(billWriter.writeBills(bills, new MultiplyBillItemFormatter()));
        System.out.println(billWriter.writeBills(bills, new TabbedBillItemFormatter()));

        System.out.println(billWriter.writeBills2(bills, x -> String.format("%d %s, darabja %d Ft", x.getNumber(), x.getName(), x.getUnitPrice())));

    }
}

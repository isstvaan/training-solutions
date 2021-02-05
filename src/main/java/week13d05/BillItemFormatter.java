package week13d05;

@FunctionalInterface
public interface BillItemFormatter {
    String getFormatedString(BillItem item);
}

package week03.d05;

public class Operation {
    private int leftValue;
    private int rightValue;

    public Operation(String addOperand) {
        if (addOperand == null || addOperand.isBlank()) {
            throw new IllegalArgumentException("Not valid parameter.");
        }

        String[] tmp = addOperand.split("\\+");
        if (tmp.length < 2) {
            throw new IllegalArgumentException("Not valid parameter");
        }

        leftValue = Integer.parseInt(tmp[0]);
        rightValue = Integer.parseInt(tmp[1]);
    }

    public int getResult() {
        return leftValue + rightValue;
    }
}

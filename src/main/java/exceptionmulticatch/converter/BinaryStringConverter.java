package exceptionmulticatch.converter;

public class BinaryStringConverter {
    public boolean[] binaryStringToBooleanArray(String str) {
        if (str == null)
        {
            throw new NullPointerException("binaryString null");
        }

        boolean[] results = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char chrValue = str.charAt(i);
            if (chrValue != '0' && chrValue != '1') {
                throw new IllegalArgumentException("binaryString not valid");
            }
            results[i] = chrValue == '1';
        }
        return results;
    }

    public String booleanArrayToBinaryString(boolean[] boolArray) {
        if (boolArray == null || boolArray.length == 0) {
            throw new IllegalArgumentException("Invalid parameter.");
        }

        StringBuilder resultStr = new StringBuilder(boolArray.length);
        for (boolean item : boolArray) {
            resultStr.append(item ? '1' : '0');
        }
        return resultStr.toString();
    }
}

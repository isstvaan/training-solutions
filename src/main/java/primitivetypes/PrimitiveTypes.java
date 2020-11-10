package primitivetypes;

public class PrimitiveTypes {

    public String toBinaryString(int n) {
        String binStr = "";
        int value = n;

        //Komplementer számításhoz kell
        if (value < 0) {
            value++;
        }
        while (value != 0) {
            binStr = (value % 2 != 0 ? "1" : "0") + binStr;
            value = value / 2;
        }

        binStr = padLeft(binStr, 32, '0');

        //Ha negeatív akkor a JAVA szerint vesszük a növelt érték egyes komplementerét
        if (n < 0) {
            String negativeBinStr = "";
            for (int i = 0; i < binStr.length(); i++) {
                negativeBinStr += binStr.charAt(i) == '0' ? '1' : '0';
            }
            binStr = negativeBinStr;
        }

        return binStr;
    }

    private String padLeft(String text, int length, char padChar) {
        String paddedString = text;

        for (int i = paddedString.length(); i < length; i++) {
            paddedString = padChar + paddedString;
        }
        return paddedString;
    }
}

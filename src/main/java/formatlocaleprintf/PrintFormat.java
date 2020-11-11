package formatlocaleprintf;

import java.util.Locale;

public class PrintFormat {

    public String checkException(String formatString, Integer i, Integer j) {
        try {
            return String.format(new Locale("hu", "HU"), formatString, i, j);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Not enough parameter!", ex);
        }
    }

    public String printFormattedText(Double number) {
        String formatString = "This text used a double parameter for formated string. Parameter value is :%f";
        return String.format(new Locale("hu", "HU"), formatString, number);
    }

    public String printFormattedText(int count, String fruit) {
        String formatString = "Here %d %s";
        return String.format(new Locale("hu", "HU"), formatString, count, fruit);
    }

    public String printFormattedText(int number) {
        String formatString = "The number parameter is %d";
        return String.format(new Locale("hu", "HU"), formatString, number);
    }

    public String printFormattedText(Integer i, Integer j, Integer k) {
        String formatString = "Parameter 1 value is: %d\nParameter 2 value is: %d\nParameter 3 value is: %d";
        return String.format(new Locale("hu", "HU"), formatString, i, j, k);
    }
}

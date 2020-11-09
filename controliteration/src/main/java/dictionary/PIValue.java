package dictionary;

public class PIValue {
    private static final String PI_POET = "Nem a régi s durva közelítés,\n" +
            "Mi szótól szóig így kijön\n" +
            "Betűiket számlálva.\n" +
            "Ludolph eredménye már,\n" +
            "Ha itt végezzük húsz jegyen.\n" +
            "De rendre kijő még tíz pontosan,\n" +
            "Azt is bízvást ígérhetem.\n";

    public String getPIValue() {
        String piValue = "";
        int counter = 0;
        for (int i = 0; i < PI_POET.length(); i++) {
            if (Character.isAlphabetic(PI_POET.charAt(i))) {
                counter++;
            } else {
                piValue += (piValue.length() == 1 ? "," : "") + (counter > 0 ? counter : "");
                counter = 0;
            }
        }

        return piValue;
    }

}

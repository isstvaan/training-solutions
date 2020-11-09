package csvvalid;

import java.util.ArrayList;
import java.util.List;

public class CSVValidator {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length != 4) {
                continue;
            }

            if (parts[0].indexOf('-') < 0 || parts[0].length() < 7) {
                continue;
            }

            int madeYear = Integer.parseInt(parts[1]);
            if (madeYear < 1970 || madeYear > 2019) {
                continue;
            }

            validLines.add(line);
        }
        return validLines;
    }
}

package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogParser {
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String LOG_SEPARATOR = ":";
    public static final String LOG_ROW_SEPARATOR = "\n";

    public Map<String, List<Entry>> parseLog(String log) {
        final Map<String, List<Entry>> logsMap = new HashMap<>();
        String[] logRows = log.split(LOG_ROW_SEPARATOR);

        for (String row : logRows) {
            addEntryToMap(logsMap, getEntryFromString(row));
        }
        return logsMap;
    }

    private Entry getEntryFromString(String str) {
        String[] splittedStr = str.split(LOG_SEPARATOR);

        if (splittedStr.length < 3) {
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
        try {

            return new Entry(splittedStr[0], LocalDate.parse(splittedStr[1], DATE_FORMAT), splittedStr[2]);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }

    private void addEntryToMap(Map<String, List<Entry>> entryMap, Entry entry) {
        if (!entryMap.containsKey(entry.getIpAddress())) {
            entryMap.put(entry.getIpAddress(), new ArrayList<>());
        }

        entryMap.get(entry.getIpAddress()).add(entry);
    }

}

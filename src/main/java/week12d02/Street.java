package week12d02;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Street {
    List<Site> sites = new ArrayList<>();

    public void loadSitesFromFile(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            int houseNumbersEven = 2;
            int houseNumbersOdd = 1;
            while ((line = reader.readLine()) != null) {
                Site item = getSiteFromString(line);
                if (item.isEvenSite()) {
                    item.setHouseNumber(houseNumbersEven);
                    houseNumbersEven += 2;
                } else {
                    item.setHouseNumber(houseNumbersOdd);
                    houseNumbersOdd += 2;
                }
                sites.add(item);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error.");
        }
        Collections.sort(sites);
    }

    private Site getSiteFromString(String str) {
        String[] splittedStr = str.split(" ");
        return new Site(splittedStr[0].equals("0"), Integer.parseInt(splittedStr[1]), splittedStr[2]);
    }

    public int getLastSiteHouseNumber() {
        return sites.get(sites.size() - 1).getHouseNumber();
    }

    public void writeStreetToFile(Path path, boolean evenSite) {
        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(path, StandardOpenOption.CREATE_NEW))) {
            for (Site item : sites) {
                if (evenSite && item.isEvenSite()) {
                    writer.write(item.toString());
                }
                if (!evenSite && !item.isEvenSite()) {
                    writer.write(item.toString());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File write error");
        }
    }

    public static void main(String[] args) {
        Street street = new Street();
        street.loadSitesFromFile(Street.class.getResourceAsStream("kerites.txt"));
        System.out.println(street.getLastSiteHouseNumber());
        //    street.writeStreetToFile(Path.of("test.txt"),false);
    }
}

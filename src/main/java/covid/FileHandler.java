package covid;

import methodoverloading.pub.Pub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public List<Citizen> getCitizensFromCsv(String path) {
        if (!Validator.isValidPath(path)) {
            throw new IllegalArgumentException("Érvénytelen elérési út!");
        }

        List<Citizen> citizens = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line = reader.readLine();//Drop header
            while ((line = reader.readLine()) != null) {
                citizens.add(Citizen.fromCsvFormat(line));
            }
            return citizens;
        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
    }

    public void generateVaccinatingReport(String path, List<Citizen> citizens) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\r\n");

            String zipTmp = "";
            LocalTime time = LocalTime.of(8, 0);
            for (Citizen item : citizens) {
                if (!zipTmp.equals(item.getZip())) {
                    zipTmp = item.getZip();
                    time = LocalTime.of(8, 0);
                }
                writer.write(time.toString() +
                        ";" + item.getName() +
                        ";" + item.getZip() +
                        ";" + item.getAge() +
                        ";" + item.getEmail() +
                        ";" + item.getTaj() +
                        "\r\n");

                time = time.plusMinutes(30);
            }

        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
    }

    public void generateVaccinatedReport(String path, List<String> vaccinatedDatas) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write("Irányítószám;Beoltatlan;Beoltott;Teljes beoltás\r\n");
            for (String item : vaccinatedDatas) {
                writer.write(item);
                writer.write("\r\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }
    }
}

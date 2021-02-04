package week13d04;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Map;

public class TemplateEngine {
    public void merge(BufferedReader reader, Map<String, Object> objects, BufferedWriter writer) {
        try (reader; writer) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(replaceObjects(line, objects));
                writer.newLine();
            }

        } catch (IOException e) {
            throw new IllegalStateException("File read error.");
        }
    }

    private String replaceObjects(String str, Map<String, Object> objects) {
        String retVal = str;
        for (Map.Entry<String, Object> item : objects.entrySet()) {
            retVal = retVal.replace("{" + item.getKey() + "}", item.getValue().toString());
        }
        return retVal;
    }

    public static void main(String[] args) throws IOException {
        TemplateEngine engine = new TemplateEngine();
        engine.merge(new BufferedReader(new InputStreamReader(TemplateEngine.class.getResourceAsStream("template.txt"))), Map.of("nev", "John Doe",
                "datum", LocalDate.now(),
                "osszeg", 12546,
                "hatarido", LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth().getValue() + 1, LocalDate.now().getDayOfMonth())),
                Files.newBufferedWriter(Path.of("templateReplaced.txt"), StandardOpenOption.CREATE));

    }
}

//Kedves {nev}!
//Megküldjük önnek a következő esedékes számláját {datum} dátummal,
//melynek összege: {osszeg} Ft!
//A fizetési határidő {hatarido}.
//Üdvözlettel,
//Ügyfélszolgálat
//A metódus második paraméterként egy Map-ben kapja az értékeket:
//{"nev" = "John Doe", "datum" = LocalDate}
//A feladat, hogy a writer-be ki kell írni a levelet, de már
//kicserélve az értékeket.
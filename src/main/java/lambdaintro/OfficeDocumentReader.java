package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {

    public List<File> listOfficeDocuments(File path) {
        List<File> files = Arrays.asList(path.listFiles(f -> f.isFile() &&
                        (f.getName().toLowerCase().endsWith(".docx") ||
                        f.getName().toLowerCase().endsWith(".xlsx") ||
                        f.getName().toLowerCase().endsWith(".pptx")))
        );
        files.sort(Comparator.comparing(File::getName));
        return files;
    }
}

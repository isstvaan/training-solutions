package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private Path path;
    private List<Human> humans;

    public FileManager(String path) {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Null parameter");
        }
        this.path = Path.of(path);
        humans = new ArrayList<>();
    }

    public void readFromFile() {
        humans.clear();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String item : lines) {
                String[] splittedStr = item.split(" ");
                humans.add( new Human(splittedStr[0], splittedStr[1]));
            }
        } catch (IOException ex) {
            throw new IllegalStateException("Can not read file", ex);
        }
    }

    public Path getMyFile() {
        return path;
    }

    public List<Human> getHumans() {
        return humans;
    }
}

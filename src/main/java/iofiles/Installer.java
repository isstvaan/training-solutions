package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {
    private static final Path SOURCE_DIR = Path.of("src/main/resources/install/");

    public void install(String pathStr) {
        if (pathStr == null || pathStr.isBlank()) {
            throw new IllegalArgumentException("Path can't be empty or null");
        }

        Path destination = Path.of(pathStr);
        if (!Files.exists(destination) || !Files.isDirectory(destination)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(SOURCE_DIR.resolve("install.txt"))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectories(destination.resolve(line));
                } else {
                    Files.copy(Files.newInputStream(SOURCE_DIR.resolve(line)), destination.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException(SOURCE_DIR.resolve("install.txt").toString() + " not found.", e);
        }
    }

    public static void main(String[] args) {
        new Installer().install("c:/test");
        System.out.println(Files.exists(Path.of("src/main/resources/install/install.txt")));
    }
}

package properties;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Properties;

public class DatabaseConfiguration {
    private static final String ENCODING = "UTF-8";
    Properties properties = new Properties();

    public DatabaseConfiguration() {
        try {
            properties.load(new InputStreamReader(DatabaseConfiguration.class.getResourceAsStream("db.properties"), Charset.forName("UTF-8")));
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found!");
        }
    }


    public DatabaseConfiguration(File file) {
        try {
            properties.load(Files.newBufferedReader(file.toPath(), Charset.forName(ENCODING)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port", "0"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }
}

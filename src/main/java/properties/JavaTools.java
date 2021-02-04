package properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    private static final String ENCODING = "UTF-8";
    Properties properties = new Properties();

    public JavaTools() {
        try {
            properties.load(new InputStreamReader(DatabaseConfiguration.class.getResourceAsStream("javatools.properties"), Charset.forName("UTF-8")));
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found!");
        }
    }


    public String getName(String paramName) {
        return properties.getProperty(paramName + ".name");
    }

    public Set<String> getTools() {
        Set<String> result = new HashSet<>();
        for (String key : getToolKeys()) {
            result.add(getName(key));
        }
        return result;
    }

    public Set<String> getToolKeys() {
        Set<String> keys = properties.stringPropertyNames();
        Set<String> result = new HashSet<>();

        for (String key : keys) {
            if (key.contains("name")) {
                result.add(key.substring(0, key.indexOf('.')));
            }
        }

        return result;
    }

    public String getUrl(String paramName) {
        return properties.getProperty(paramName + ".url");

    }
}

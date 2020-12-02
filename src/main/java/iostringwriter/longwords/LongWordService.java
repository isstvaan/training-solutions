package iostringwriter.longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    private String writeString(List<String> words, Writer writer) {
        if (writer == null) {
            throw new IllegalArgumentException("Writer is null");
        }
        if (words == null) {
            throw new IllegalArgumentException("Words can't be null");
        }

        try (writer) {
            for (String item : words) {
                writer.write(item + " " + item.length() + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file");
        }
        return writer.toString();
    }

    public String writeWithStringWriter(List<String> words) {
        return writeString(words, new StringWriter());
    }
}

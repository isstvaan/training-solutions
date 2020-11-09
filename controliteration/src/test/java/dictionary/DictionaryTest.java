package dictionary;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DictionaryTest {
    @Test
    public void shouldFind() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));

        List<String> translations = dictionary.findTranslations("kutya");
        assertEquals(Arrays.asList("pooch", "dog"), translations);
    }

    @Test
    public void shouldAppend() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));
        dictionary.addItem("kutya", Collections.singletonList("dawg"));

        List<String> translations = dictionary.findTranslations("kutya");
        assertEquals(Arrays.asList("pooch", "dog", "dawg"), translations);
    }

    @Test
    public void shouldAppendOnlyOnce() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));
        dictionary.addItem("kutya", Collections.singletonList("dawg"));
        dictionary.addItem("kutya", Collections.singletonList("dawg"));

        List<String> translations = dictionary.findTranslations("kutya");
        assertEquals(Arrays.asList("pooch", "dog", "dawg"), translations);
    }
}

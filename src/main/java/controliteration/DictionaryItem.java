package controliteration;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {
    private String word;
    private List<String> translations;

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        this.translations = new ArrayList<>();
        addTranslations(translations);
    }

    public void addTranslations(List<String> newTranslations) {
        for (String newItem : newTranslations) {
            if (!translations.contains(newItem)) {
                translations.add(newItem);
            }
        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }
}

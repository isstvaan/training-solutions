package dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String word, List<String> translations) {

        boolean wordIsExists = false;
        for (DictionaryItem dictionaryItem : dictionaryItems) {
            if (dictionaryItem.getWord().equals(word)) {
                dictionaryItem.addTranslations(translations);
                wordIsExists = true;
                break;
            }
        }
        if (!wordIsExists) {
            dictionaryItems.add(new DictionaryItem(word, translations));
        }
    }

    public List<String> findTranslations(String word)
    {
        for (DictionaryItem dictionaryItem : dictionaryItems) {
            if (dictionaryItem.getWord().equals(word)) {
                return dictionaryItem.getTranslations();
            }
        }

        return new ArrayList<>();
    }
}

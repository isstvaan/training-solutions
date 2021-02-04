package week13d03;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AuthorMostPages {
    private Map.Entry<String, Integer> getMaxPageAuthor(Map<String, Integer> authors) {
        int maxPage = 0;
        Map.Entry<String, Integer> retVal = null;
        for (Map.Entry<String, Integer> item : authors.entrySet()) {
            if (maxPage < item.getValue()) {
                maxPage = item.getValue();
                retVal = item;
            }
        }
        return retVal;
    }

    private Map<String, Integer> getAuthorPagesMap(List<Book> books) {
        Map<String, Integer> retVal = new TreeMap<>();
        for (Book item : books) {
            if (!retVal.containsKey(item.getAuthor())) {
                retVal.put(item.getAuthor(), item.getNumberOfPages());
            }
            int value = retVal.get(item.getAuthor());
            value += item.getNumberOfPages();
            retVal.put(item.getAuthor(), value);
        }
        return retVal;
    }

    public String getMostPagesAuthor(List<Book> books) {
        Map<String, Integer> authorPagesMap = getAuthorPagesMap(books);

        Map.Entry<String, Integer> maxPageAuthor = getMaxPageAuthor(authorPagesMap);

        return maxPageAuthor.getKey();
    }


}

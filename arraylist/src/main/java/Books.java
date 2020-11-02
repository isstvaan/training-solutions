import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> titles = new ArrayList<>();

    public void add(String title) {
        titles.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> retVal = new ArrayList<>();
        for (String title : titles) {
            if (title.startsWith(prefix)) {
                retVal.add(title);
            }
        }
        return retVal;
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.add("Egy cím 1");
        books.add("Egy cím 2");
        books.add("Kettő cím 1");
        books.add("Kettő cím 2");
        books.add("Plus one");

        System.out.println("Könyvek: " + books.getTitles());

        System.out.println("Könyvek a ket kifejezésre: " + books.findAllByPrefix("Ket"));

        books.removeByPrefix("Egy");
        System.out.println("Könyvek: " + books.getTitles());
    }

    public void removeByPrefix(String prefix) {
        List<String> tmp = new ArrayList<>();
        for (String title : titles) {
            if (title.startsWith(prefix)) {
                tmp.add(title);
            }
        }

        titles.removeAll(tmp);
    }
}

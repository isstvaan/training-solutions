package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable {
    private List<String> pages = new ArrayList<>();

    public void addPage(String string) {
        pages.add(string);
    }

    @Override
    public int getLength() {
        return pages.size();
    }

    @Override
    public String getPage(int index) {
        if (index > pages.size() || index < 0)
        {
            return null;
        }
        return pages.get(index);
    }
}

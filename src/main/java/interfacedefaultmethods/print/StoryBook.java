package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable {
    List<ColoredPage> coloredPage = new ArrayList<>();

    public void addPage(String content, String color) {
        coloredPage.add(new ColoredPage(content, color));
    }

    @Override
    public int getLength() {
        return coloredPage.size();
    }

    @Override
    public String getPage(int index) {
        if (index > coloredPage.size() || index < 0) {
            return null;
        }
        return coloredPage.get(index).getContent();
    }

    @Override
    public String getColor(int color) {
        return coloredPage.get(color).getColor();
    }
}

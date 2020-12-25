package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature {

    private final List<String> authors;
    private final int numberOfPages;
    private final String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }

        if (numberOfPages < 0) {
            throw new IllegalArgumentException("Invalid page number");
        }

        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("Empty authors");
        }

        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }
}

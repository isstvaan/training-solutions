package catalog;

public class SearchCriteria {
    private final String contributor;
    private final String title;

    private SearchCriteria(String title, String contributor) {
        if (contributor == null) {
            throw new IllegalArgumentException("Invalid contributor");
        }
        if (title == null) {
            throw new IllegalArgumentException("Invalid title");
        }
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByBoth(String contributor, String title) {
        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        return new SearchCriteria("", contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        return new SearchCriteria(title, "");
    }

    public boolean hasContributor() {
        return !Validators.isBlank(contributor);
    }

    public boolean hasTitle() {
        return !Validators.isBlank(title);
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }
}

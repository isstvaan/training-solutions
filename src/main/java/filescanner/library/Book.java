package filescanner.library;

public class Book {
    private String author;
    private String title;
    private String regNum;
    private int yearOfPublish;

    public Book(String author, String title, String regNum, int yearOfPublish) {
        this.author = author;
        this.title = title;
        this.regNum = regNum;
        this.yearOfPublish = yearOfPublish;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}

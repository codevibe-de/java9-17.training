package book;

public class Book {

    private String isbn;
    private String title;
    private Integer year;
    private String author;

    public Book(String isbn, String title, Integer year, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [" + isbn + ", " + title + ", " + year + ", " + author + "]";
    }

}

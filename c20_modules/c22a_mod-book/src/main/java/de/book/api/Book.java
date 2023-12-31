package de.book.api;

public class Book {

    private String isbn;
    private String title;
    private Integer year;
    private String author;

    public Book() {
    }

    public Book(String isbn, String title, Integer year, String author) {
        checkIsbn(isbn);
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private void checkIsbn(String isbn) throws IllegalArgumentException {
        // noop
    }

    @Override
    public String toString() {
        return "Book[" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ']';
    }
}

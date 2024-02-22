package book.api;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public record Book(
        String isbn,
        String title,
        Integer year,
        String author
) implements Comparable<Book> {

    public Book(String isbn, String title, Integer year, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.author = author;
        checkIsbn(isbn);
    }

    private void checkIsbn(String isbn) throws IllegalArgumentException {
        // noop
    }

    @Override
    public int compareTo(Book that) {
        if (that == null) {
            return -1;
        } else {
            return StringUtils.compare(this.isbn, that.isbn);
        }
    }
}

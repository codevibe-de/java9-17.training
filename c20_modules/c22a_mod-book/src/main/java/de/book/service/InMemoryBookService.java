package de.book.service;

import de.book.api.Book;
import de.book.api.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InMemoryBookService implements BookService {

    private final Random random = new Random();

    private List<Book> books = new ArrayList<>();

    @Override
    public String generateIsbn() {
        return String.format("978-3-%5d-%3d-0",
                random.nextInt(100000),
                random.nextInt(1000));
    }

    @Override
    public Book addBook(String title, String author, Integer year, String isbn) {
        var book = new Book(
                (isbn == null || isbn.isBlank()) ? generateIsbn() : isbn,
                title,
                year,
                author
        );
        books.add(book);
        return book;
    }
}

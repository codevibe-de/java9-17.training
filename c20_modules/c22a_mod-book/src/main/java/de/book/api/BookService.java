package de.book.api;

import de.book.service.InMemoryBookService;

public interface BookService {

    String generateIsbn();

    Book addBook(String title, String author, Integer year, String isbn);

    final BookService INSTANCE = new InMemoryBookService();

}

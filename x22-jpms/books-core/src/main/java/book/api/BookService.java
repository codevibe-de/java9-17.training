package book.api;

import book.service.InMemoryBookService;

public interface BookService {

    String generateIsbn();

    Book addBook(String title, String author, Integer year, String isbn);

    final BookService INSTANCE = new InMemoryBookService();

}

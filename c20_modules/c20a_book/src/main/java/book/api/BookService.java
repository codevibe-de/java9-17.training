package book.api;

import book.Book;
import book.DefaultBookService;

public interface BookService {

    BookService INSTANCE = new DefaultBookService();

    Book createBook(String isbn, String title);

}

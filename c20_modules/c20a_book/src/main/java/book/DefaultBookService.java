package book;

import book.api.BookService;

public class DefaultBookService implements BookService {

    @Override
    public Book createBook(String isbn, String title) {
        return new Book(
                isbn,
                title,
                null,
                null
        );
    }

    @SuppressWarnings("unused")
    void somePackagePrivateMethod() {}

}

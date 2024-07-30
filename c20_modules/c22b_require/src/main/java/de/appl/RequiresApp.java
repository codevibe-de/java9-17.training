package de.appl;

import de.book.api.BookService;
import org.assertj.core.api.Assertions;

public class RequiresApp {

    public static void main(String[] args) {
        BookService bookService = BookService.INSTANCE;
        var book = bookService.addBook("Title", "Author", null, null);
        System.out.println(book);

        System.out.println(bookService.getClass());

        Assertions.assertThatExceptionOfType(IllegalAccessException.class)
                .isThrownBy(() -> {
                    Class.forName("de.book.service.InMemoryBookService")
                            .getDeclaredConstructor()
                            .newInstance();
                });
    }

}

package appl.c_visibility;

import book.DefaultBookService;
import book.api.BookService;

public class ProblemClassVisibilityApp {

    public static void main(String[] args) {
        // problem 3/5: we only want visibility to BookService, not its implementing classes
        BookService bookService = new DefaultBookService();
        bookService = BookService.INSTANCE; // doesn't help much
        bookService.createBook("123-345", "A Great Book");
    }

}

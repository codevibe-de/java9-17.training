package appl.b_visibility;

import book.api.BookService;

public class ProblemClassVisibilityApp {

    public static void main(String[] args) {
        // we only want visibility to BookService, not its implementing classes
        BookService bookService = BookService.INSTANCE;
        bookService.createBook("123-345", "A Great Book");
    }

}

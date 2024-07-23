package appl.c_visibility;

import book.DefaultBookService;
import book.api.BookService;

public class ProblemClassVisibilityApp {

    public static void main(String[] args) {
        // problem 3/5: we only want visibility to BookService, not its implementing class DefaultBookService
        BookService bookService = new DefaultBookService();

        // using a Singleton (or Factory) pattern can help to some extent, however, in our case DefaultBookService
        // had to be declared public and hence we can still access DefaultBookService if we really want
        DefaultBookService bookService2 = (DefaultBookService) BookService.INSTANCE;
    }

}

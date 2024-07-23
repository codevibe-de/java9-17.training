package appl.d_reflection;

import book.Book;
import book.api.BookService;

public class ProblemReflectionAccessApp {

    public static void main(String[] args) {
        Book book = BookService.INSTANCE.createBook("123", "The Insight");
        // problem 4/5
        System.out.println(Mapper.extractFields(book));
    }
}

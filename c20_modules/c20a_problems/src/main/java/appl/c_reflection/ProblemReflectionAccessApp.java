package appl.c_reflection;

import book.Book;
import book.api.BookService;

public class ProblemReflectionAccessApp {

    public static void main(String[] args) {
        Book book = BookService.INSTANCE.createBook("123", "The Insight");
        System.out.println(Mapper.extractFields(book));
    }
}

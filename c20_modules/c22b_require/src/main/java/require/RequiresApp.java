package require;

import book.api.BookService;
import org.assertj.core.api.Assertions;

import java.lang.reflect.InvocationTargetException;

import static utils.MethodLogger.logMethodCall;

public class RequiresApp {

    public static void main(String[] args) throws Exception {
        demoBookServiceAccess();
    }

    static void demoBookServiceAccess() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        logMethodCall();

        BookService bookService = BookService.INSTANCE;
        var book = bookService.addBook("Title", "Author", null, null);
        System.out.println(book);

        System.out.println(bookService.getClass());

        Assertions.assertThatExceptionOfType(IllegalAccessException.class)
                .isThrownBy(() -> {
                    Class.forName("book.service.InMemoryBookService")
                            .getDeclaredConstructor()
                            .newInstance();
                });
    }

}

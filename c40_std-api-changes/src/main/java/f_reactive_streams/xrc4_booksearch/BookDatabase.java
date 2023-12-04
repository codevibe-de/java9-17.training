package f_reactive_streams.xrc4_booksearch;

import java.util.List;
import java.util.concurrent.Flow.Subscriber;

public class BookDatabase {

    private final List<Book> books = List.of(
            new Book("1111", "Java ist auch eine Insel", "Ullenbohm"),
            new Book("2222", "Sprechen Sie Java?", "Mössenböck"),
            new Book("3333", "Effective Java", "Bloch"),
            new Book("4444", "Modula", "Wirth"),
            new Book("5555", "Modula-2", "Wirth")
    );

    public void find(Subscriber<Book> subscriber, String title) {
        // todo implement
    }
}

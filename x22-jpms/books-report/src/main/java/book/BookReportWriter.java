package book;

import book.api.Book;

import java.util.Collection;
import java.util.stream.Collectors;

public interface BookReportWriter<T> {

    T generateReport(Collection<Book> books);

    static BookReportWriter<String> getStringInstance() {
        return new BookReportWriter<String>() {
            @Override
            public String generateReport(Collection<Book> books) {
                return books.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"));
            }
        };
    }
}

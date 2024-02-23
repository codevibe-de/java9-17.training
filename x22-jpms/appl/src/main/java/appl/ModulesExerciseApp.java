package appl;

import appl.reflection.Mapper;
import book.api.Book;
import book.api.Publisher;
import book.io.BookReader;
import book.io.BookReportWriter;
import org.apache.commons.lang3.StringUtils;
import org.fusesource.jansi.AnsiConsole;

import java.util.List;
import java.util.Objects;

import static appl.jansi_ext.JansiColors.*;

public class ModulesExerciseApp {

    public ModulesExerciseApp() {
        AnsiConsole.systemInstall();
        cyan.println("\nApp starting...");
    }

    public static void main(String[] args) {
        // setup
        var app = new ModulesExerciseApp();
        printSeparator();

        // work with books-core API
        app.createAndPrintBook();
        printSeparator();

        // use reflection with books-core classes
        app.investigate(new Book("123-456", "Test", 2000, "The Duke"));
        app.investigate(new Publisher("Sun Microsystems"));

        // work with books-report API
        printSeparator();
        app.importBooksAndPrintReport();

        // done
        System.out.println();
    }

    private static void printSeparator() {
        yellow.println(StringUtils.repeat('-', 80));
    }

    private Book createAndPrintBook() {
        var book = new Book("0-19-501919-9", "A Pattern Language", 1977, "Christopher Alexander");
        System.out.println(book);
        return book;
    }

    private void investigate(Object instance) {
        System.out.println("Fields of " + instance);
        var fields = Mapper.extractFields(instance);
        fields.entrySet().forEach(e -> {
            regular.print("  - ");
            green.print(e.getKey());
            regular.println(": " + e.getValue());
        });
    }

    private void importBooksAndPrintReport() {
        try {
            String resourceName = "books.csv";
            var in = Objects.requireNonNull(
                    ClassLoader.getSystemResourceAsStream(resourceName),
                    "Resource '%s' not found".formatted(resourceName)
            );
            List<Book> books = new BookReader().readBooksFromCsv(in);
            String report = BookReportWriter.getStringInstance().generateReport(books);
            cyan.println(report);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

package appl;

import appl.reflection.Mapper;
import book.api.Book;
import book.api.Publisher;
import org.apache.commons.lang3.StringUtils;
import org.fusesource.jansi.AnsiConsole;

import static appl.jansi_ext.JansiColors.*;

public class ModulesExerciseApp {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        cyan.println("\nApp starting...");
        yellow.println(StringUtils.repeat('-', 80));

        var book = createAndPrintBook();

        yellow.println(StringUtils.repeat('-', 80));

        investigate(book);
        investigate(new Publisher("Random House"));

        System.out.println();
    }

    private static Book createAndPrintBook() {
        var book = new Book("0-19-501919-9", "A Pattern Language", 1977, "Christopher Alexander");
        System.out.println(book);
        return book;
    }

    private static void investigate(Object instance) {
        System.out.println("Fields of " + instance);
        var fields = Mapper.extractFields(instance);
        fields.entrySet().forEach(e -> {
            regular.print("  - ");
            green.print(e.getKey());
            regular.println(": " + e.getValue());
        });
    }

}

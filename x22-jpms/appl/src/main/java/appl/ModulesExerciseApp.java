package appl;

import appl.reflection.Mapper;
import org.apache.commons.lang3.StringUtils;
import org.fusesource.jansi.AnsiConsole;

import static appl.jansi_ext.JansiColors.*;

public class ModulesExerciseApp {

    // --- main logic ---

    public static void main(String[] args) {
        // # Setup
        var app = new ModulesExerciseApp();
        printSeparator();

        // # Work with books-core API
//        System.out.println(new Book("0-19-501919-9", "A Pattern Language", 1977, "Christopher Alexander"));
//        printSeparator();

        // # Use reflection with books-core classes
//        app.investigate(new Book("123-456", "Test", 2000, "The Duke"));
//        app.investigate(new Publisher("Sun Microsystems"));

        // # Work with books-report API
//        printSeparator();
//        String resourceName = "books.csv";
//        var in = Objects.requireNonNull(
//                ClassLoader.getSystemResourceAsStream(resourceName),
//                "Resource '%s' not found".formatted(resourceName)
//        );
//        String report = BookReportWriter.getStringInstance().generateReport(
//                new BookReader().readBooksFromCsv(in)
//        );
//        cyan.println(report);

        // # Done
        System.out.println();
    }


    // --- constructor and helpers ---

    public ModulesExerciseApp() {
        AnsiConsole.systemInstall();
        cyan.println("\nApp starting...");
    }


    private static void printSeparator() {
        yellow.println(StringUtils.repeat('-', 80));
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

}

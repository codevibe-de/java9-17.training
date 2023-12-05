package de.appl;

import book.io.BookReader;
import book.io.BookReportWriter;

import java.nio.file.Paths;

public class IndirectApp {

    public static void main(String[] args) throws Exception {
        //
        var books = new BookReader().readBooksFromCsv(
                Paths.get(ClassLoader.getSystemResource("books.csv").toURI())
        );

        // regular access to members of required module
        var report = BookReportWriter
                .getStringInstance()
                .generateReport(books);
        System.out.println(report);

        // reflection access to public members of indirectly required module
        var book = Class.forName("de.book.api.Book")
                .getDeclaredConstructor()
                .newInstance();
        System.out.println(book);
    }

}

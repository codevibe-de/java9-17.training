package indirect;

import book.report.BookReportWriter;

import java.util.List;

public class IndirectApp {

    public static void main(String[] args) throws Exception {
        // regular access to members of required module
        BookReportWriter
                .getStringInstance()
                .generateReport(List.of());

        // reflection access to public members of indirectly required module
        var book = Class.forName("book.api.Book")
                .getDeclaredConstructor()
                .newInstance();
        System.out.println(book);
    }

}

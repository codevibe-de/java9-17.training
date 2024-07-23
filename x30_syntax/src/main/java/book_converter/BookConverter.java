package book_converter;

public class BookConverter {

    public static final BookConverter INSTANCE = new BookConverter();

    public String convertBook(Book book, ContentType contentType) {
        return switch (contentType) {
            case XML -> convertToXml(book);
            case JSON -> convertToJson(book);
            case PLAIN_TEXT -> convertToPlainText(book);
        };
    }

    private String convertToXml(Book book) {
        return """
                <book>
                    <title>%s</title>
                    <author>%s</author>
                    <year>%4d</year>
                </book>
                """.formatted(book.getTitle(), book.getAuthor(), book.getYear());
    }

    private String convertToJson(Book book) {
        return """
                {
                    "title": "%s",
                    "author": "%s",
                    "year": %4d
                }
                """.formatted(book.getTitle(), book.getAuthor(), book.getYear());
    }

    private String convertToPlainText(Book book) {
        return """
                %s
                - Author: %s
                - Year: %4d
                """.formatted(book.getTitle(), book.getAuthor(), book.getYear());

    }

}

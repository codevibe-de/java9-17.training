package book_converter;

public class BookConverterApp {

    public static void main(String[] args) {
        var book = new Book("Java 9 Modularity", "Sander Mak");
        System.out.println(
                BookConverter.INSTANCE.convertBook(book, ContentType.XML)
        );
        System.out.println(
                BookConverter.INSTANCE.convertBook(book, ContentType.JSON)
        );
        System.out.println(
                BookConverter.INSTANCE.convertBook(book, ContentType.PLAIN_TEXT)
        );
    }
}

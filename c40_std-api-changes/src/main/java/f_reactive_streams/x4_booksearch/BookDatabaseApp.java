package f_reactive_streams.x4_booksearch;

public class BookDatabaseApp {

    public static void main(String[] args) {
        final BookDatabase bookDatabase = new BookDatabase();
        new BookFrame(bookDatabase);
    }

}
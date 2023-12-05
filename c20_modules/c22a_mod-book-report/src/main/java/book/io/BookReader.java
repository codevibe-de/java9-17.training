package book.io;

import de.book.api.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BookReader {

    public List<Book> readBooksFromCsv(Path csvFilePath) throws IOException {
        return Files.readAllLines(csvFilePath).stream()
                .map(l -> l.split(","))
                .filter(parts -> parts.length == 4)
                .map(parts -> new Book(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]))
                .toList();
    }

}

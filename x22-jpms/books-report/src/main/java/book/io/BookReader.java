package book.io;

import book.api.Book;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BookReader {

    public List<Book> readBooksFromCsv(InputStream in) throws IOException {
        var content = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        return content.lines()
                .map(l -> l.split(","))
                .filter(parts -> parts.length == 4)
                .map(parts -> new Book(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]))
                .toList();
    }

}

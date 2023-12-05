package v_file_readwrite_string;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileReadWriteApp {

    @Test
    void readString() throws IOException {
        Path path = Path.of("pom.xml");
        String content = Files.readString(path);
        System.out.println(content.length());
    }


    @Test
    void readSplitAndPrint() throws IOException {
        Path path = Path.of("pom.xml");
        Files.readString(path)
                .lines()
                .forEach(System.out::println);
    }


    @Test
    void writeString() throws IOException {
        Path path = Path.of("output.tmp");
        Files.writeString(path, "Hello");
        Files.writeString(path, "\nWorld", StandardOpenOption.APPEND);
    }
}

package l_stream;

import org.junit.jupiter.api.Test;
import utils.MethodLogger;

import java.util.List;
import java.util.stream.Stream;

public class StreamApp {

    @Test
    void demoDropWhile() {
        MethodLogger.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .dropWhile(v -> v < 13)
                .forEach(System.out::println);
    }


    @Test
    void demoTakeWhile() {
        MethodLogger.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .takeWhile(v -> v < 12)
                .forEach(System.out::println);
    }


    @Test
    void demoDropWhileTakeWhile() {
        MethodLogger.logMethodCall();
        Stream.of(10, 11, 12, 13, 14, 15)
                .dropWhile(v -> v < 12)
                .takeWhile(v -> v < 15)
                .forEach(System.out::println);
    }


    @Test
    void demoDropWhileTakeWhileForHtml() {
        MethodLogger.logMethodCall();
        Stream.of("<html>",
                        "<head>",
                        "<title>Foo</title>",
                        "</head>",
                        "<body>",
                        "<h1>Foo</h1>",
                        "<p>Bar</p>",
                        "</body>",
                        "</html>")
                .dropWhile(s -> !s.equals("<body>"))
                .skip(1)
                .takeWhile(s -> !s.equals("</body>"))
                .forEach(System.out::println);
    }


    @Test
    void demoOfNullable() {
        MethodLogger.logMethodCall();
        Stream<String> s1 = Stream.ofNullable(null);
        s1.forEach(System.out::println);
        Stream<String> s2 = Stream.ofNullable("Hello");
        s2.forEach(System.out::println);
    }


    @Test
    void demoIterate() {
        MethodLogger.logMethodCall();
        Stream<Integer> s = Stream.iterate(
                5,
                i -> i < 10,
                i -> i + 2);
        s.forEach(System.out::print); // 579
    }


    @Test
    void toList() {
        List<Integer> integers = Stream.of(1, 2, 3, 4, 5, 6)
                .filter(v -> v % 2 == 0)
                .toList();
        System.out.println(integers);
    }
}
